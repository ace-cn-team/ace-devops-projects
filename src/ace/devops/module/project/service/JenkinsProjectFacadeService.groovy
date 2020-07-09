package ace.devops.module.project.service

import ace.devops.module.project.model.bo.Project

/**
 * @author Caspar* @contract 279397942@qq.com
 * @create 2020/7/9 15:12
 * @description
 */
class JenkinsProjectFacadeService {
    private ProjectService projectService;
    /**
     * 查对对应的项目配置
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
}