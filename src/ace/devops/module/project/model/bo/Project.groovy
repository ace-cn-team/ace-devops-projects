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

}
