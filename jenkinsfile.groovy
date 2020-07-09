@Library("ace-devops-utils@master")
import ace.devops.module.project.ProjectDefaultContext
import ace.devops.module.project.service.JenkinsProjectFacadeService
import ace.devops.module.project.service.ProjectService
import groovy.json.JsonOutput

node {
    ProjectDefaultContext projectDefaultContext = new ProjectDefaultContext();
    ProjectService projectService = projectDefaultContext.projectService;
    JenkinsProjectFacadeService jenkinsProjectFacadeService = projectDefaultContext.jenkinsProjectFacadeService;

    properties([
            parameters([
                    choice(choices: jenkinsProjectFacadeService.getChoiceFromProjects(), description: '选择项目', name: 'projectIdSelected'),
            ])
    ])

    def projectConfigSelected = projectService.findProjectConfigSelected(projectIdSelected);

    if (projectConfigSelected == null) {
        throw new RuntimeException(String.format("%s没有对应配置", projectIdSelected));
    }

    def aceWorkspace = jenkinsProjectFacadeService.getProjectWorkSpace(projectConfigSelected);

    ws(aceWorkspace) {

        stage('git checkout') {
            checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: projectConfigSelected.gitCredentialsId, url: projectConfigSelected.gitUrl]]])
        }

        stage('mvn clean package') {
            def mvn_cmd = '/var/jenkins_home/tools/hudson.tasks.Maven_MavenInstallation/maven3.6.3/bin/mvn';
            def pom_path = jenkinsProjectFacadeService.getProjectPomFileAbsolutePath(WORKSPACE, projectConfigSelected);
            sh "${mvn_cmd} -f ${pom_path} clean package -e -U -Dmaven.test.skip=true";
        }
    }
}