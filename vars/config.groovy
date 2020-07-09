// 所有项目配置
def allProjectConfigs = [
        [
                // 项目的唯一标识
                id                 : "ace-account-base-api-web",
                // 项目目录名称
                projectDirName     : "ace-account-base-api-web",
                // git 项目url
                gitUrl             : "https://github.com/ace-cn-team/ace-account-base-projects.git",
                // git 在jenkins中的凭证名称
                gitCredentialsId   : "ace-jenkins",
                // 相对路径
                pomFileRelativePath: "/ace-account-base-api-web/pom.xml",
        ],
];

// 查对对应的项目配置
def findProjectConfigSelected(allProjectConfigs, projectIdSelected) {
        for (int i = 0; i < allProjectConfigs.size(); i++) {
                def curProjectConfig = allProjectConfigs.get(i);
                if (curProjectConfig.id.equalsIgnoreCase(projectIdSelected)) {
                        return curProjectConfig;
                }
        }
        return null;
};
