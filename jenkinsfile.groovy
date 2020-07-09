library identifier: 'ace-devops-utils@master', retriever: modernSCM(
        [$class       : 'GitSCMSource',
         remote       : 'https://github.com/ace-cn-team/ace-devops-projects.git',
         credentialsId: 'ace-jenkins'
        ]
)
import ace.devops.config;
node {
    config a = new config();
    echo a.allProjectConfigs;
}