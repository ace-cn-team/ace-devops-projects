package ace.devops.module.project.model.bo

/**
 * @author Caspar* @contract 279397942@qq.com
 * @create 2020/7/9 15:17
 * @description
 */
class Project {
    /**
     *  项目的唯一标识
     */
    private String id;
    /**
     * 项目目录名称
     */
    private String projectDirName;
    /**
     * git 项目url
     *
     */
    private String gitUrl;

    /**
     * git 在jenkins中的凭证名称
     */
    private String gitCredentialsId;
    /**
     * pom文件相对路径
     */
    private String pomFileRelativePath;

    String getId() {
        return id
    }

    void setId(String id) {
        this.id = id
    }

    String getProjectDirName() {
        return projectDirName
    }

    void setProjectDirName(String projectDirName) {
        this.projectDirName = projectDirName
    }

    String getGitUrl() {
        return gitUrl
    }

    void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl
    }

    String getGitCredentialsId() {
        return gitCredentialsId
    }

    void setGitCredentialsId(String gitCredentialsId) {
        this.gitCredentialsId = gitCredentialsId
    }

    String getPomFileRelativePath() {
        return pomFileRelativePath
    }

    void setPomFileRelativePath(String pomFileRelativePath) {
        this.pomFileRelativePath = pomFileRelativePath
    }
}
