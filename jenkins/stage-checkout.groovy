def config = load "config.groovy";
node {
    def allProjectConfigs = config.allProjectConfigs;
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < allProjectConfigs.size(); i++) {
        def projectConfig = allProjectConfigs.get(i);
        sb.append(projectConfig.id);
        sb.append("\n")
    }
    properties([
            parameters([
                    choice(choices: sb.toString(), description: '选择项目', name: 'projectIdSelected'),
            ])
    ])

    def projectConfigSelected = findProjectConfigSelected(allProjectConfigs, projectIdSelected);

    if (projectConfigSelected == null) {
        throw new RuntimeException(String.format("%s没有对应配置", projectIdSelected));
    }
    def aceWorkspace = "/var/jenkins_home/ace/tmp/${projectConfigSelected.projectDirName}";
    ws(aceWorkspace) {
        echo "work space:${WORKSPACE}";
        stage('git checkout') {
            checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: projectConfigSelected.gitCredentialsId, url: projectConfigSelected.gitUrl]]])
        }

        stage('mvn clean package') {
            def mvn_cmd = '/var/jenkins_home/tools/hudson.tasks.Maven_MavenInstallation/maven3.6.3/bin/mvn';
            def pom_path = "${WORKSPACE}/${projectConfigSelected.pomFileRelativePath}";
            sh "${mvn_cmd} -f ${pom_path} clean package -e -U -Dmaven.test.skip=true";
        }
    }


}