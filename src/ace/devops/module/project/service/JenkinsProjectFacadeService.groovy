package ace.devops.module.project.service

import ace.devops.module.project.model.bo.Project

/**
 * @author Caspar* @contract 279397942@qq.com
 * @create 2020/7/9 15:12
 * @description
 */
class JenkinsProjectFacadeService {
    private ProjectService projectService;
    private final static String WORK_SPACE_PREFIX = "/var/jenkins_home/ace/tmp";
    /**
     * 获取jenkins 项目ID输入参数的所有选择
     */
    def getChoiceFromProjects() {
        def allProjectConfigs = projectService.findAll();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < allProjectConfigs.size(); i++) {
            def projectConfig = allProjectConfigs.get(i);
            sb.append(projectConfig.id);
            sb.append("\n");
        }
        return sb.toString();
    };

    /**
     * 获取项目jenkins的工作空间
     * @param project
     * @return
     */
    def getProjectWorkSpace(Project project) {
        return "${WORK_SPACE_PREFIX}/${project.projectDirName}";
    }
    /**
     * 获取项目jenkins的pom.xml文件的绝对位置
     * @param project
     * @return
     */
    def getProjectPomFileAbsolutePath(Project project) {
        return "${this.getProjectWorkSpace(project)}${project.pomFileRelativePath}";
    }
}