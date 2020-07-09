import ace.devops.module.project.model.bo.Project

def getAllProjects() {
    List<Project> projects = Arrays.asList(
            new Project(
                    // 项目的唯一标识
                    id: "ace-account-base-api-web",
                    // 项目目录名称
                    projectDirName: "ace-account-base-api-web",
                    // git 项目url
                    gitUrl: "https://github.com/ace-cn-team/ace-account-base-projects.git",
                    // git 在jenkins中的凭证名称
                    gitCredentialsId: "ace-jenkins",
                    // 相对路径
                    pomFileRelativePath: "/ace-account-base-api-web/pom.xml",)
    );
    return projects;
}


def test() {
    echo "1111";
}