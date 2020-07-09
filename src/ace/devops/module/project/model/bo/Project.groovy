package ace.devops.module.project.model.bo

import com.cloudbees.groovy.cps.NonCPS

/**
 * @author Caspar* @contract 279397942@qq.com
 * @create 2020/7/9 15:17
 * @description
 */

class Project {
    /**
     *  项目的唯一标识
     */
    String id;
    /**
     * 项目目录名称
     */
    String projectDirName;
    /**
     * git 项目url
     *
     */
    String gitUrl;

    /**
     * git 在jenkins中的凭证名称
     */
    String gitCredentialsId;
    /**
     * pom文件相对路径
     */
    String pomFileRelativePath;
//    @NonCPS
//    String getId() {
//        return id
//    }
//    @NonCPS
//    void setId(String id) {
//        this.id = id
//    }
//    @NonCPS
//    String getProjectDirName() {
//        return projectDirName
//    }
//    @NonCPS
//    void setProjectDirName(String projectDirName) {
//        this.projectDirName = projectDirName
//    }
//    @NonCPS
//    String getGitUrl() {
//        return gitUrl
//    }
//    @NonCPS
//    void setGitUrl(String gitUrl) {
//        this.gitUrl = gitUrl
//    }
//    @NonCPS
//    String getGitCredentialsId() {
//        return gitCredentialsId
//    }
//    @NonCPS
//    void setGitCredentialsId(String gitCredentialsId) {
//        this.gitCredentialsId = gitCredentialsId
//    }
//    @NonCPS
//    String getPomFileRelativePath() {
//        return pomFileRelativePath
//    }
//    @NonCPS
//    void setPomFileRelativePath(String pomFileRelativePath) {
//        this.pomFileRelativePath = pomFileRelativePath
//    }
}
