@Library("ace-devops-utils@master")
import ace.devops.DefaultContext;
import ace.devops.module.project.service.ProjectService;
import ace.devops.module.jenkins.service.JenkinsProjectFacadeService;
import groovy.json.JsonOutput;

node {
    // 初始化相关工具类
    DefaultContext defaultContext = new DefaultContext();
    ProjectService projectService = defaultContext.projectService;
    JenkinsProjectFacadeService jenkinsProjectFacadeService = defaultContext.jenkinsProjectFacadeService;

    // 输入参数空白的时间，创建输入参数
    properties([
            parameters([
                    choice(choices: jenkinsProjectFacadeService.getChoiceFromProjects(), description: '选择项目', name: 'projectIdSelected'),
                    choice(choices: [[name:"k",description: "k-description"],[name:"a",description: "a-description"]], description: '选择项目', name: 'projectIdSelected'),
            ])
    ]);

    def projectConfigSelected = jenkinsProjectFacadeService.findProjectIsNullThrows(projectIdSelected)

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