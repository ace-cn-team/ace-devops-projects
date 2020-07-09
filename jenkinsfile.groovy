library identifier: 'ace-devops-utils', retriever: modernSCM(
        [$class       : 'GitSCMSource',
         remote       : 'https://github.com/ace-cn-team/ace-devops-projects.git',
         credentialsId: 'ace-jenkins'
        ]
)
node {
    echo config.allProjectConfigs
}