package ace.devops.module.project.service

import ace.devops.module.project.model.bo.Project

/**
 * @author Caspar* @contract 279397942@qq.com
 * @create 2020/7/9 15:12
 * @description
 */
class ProjectService {
    private List<Project> projects;


    // 查对对应的项目配置
    findProjectConfigSelected(projectId) {
        for (int i = 0; i < this.projects.size(); i++) {
            def curProjectConfig = this.projects.get(i);
            if (curProjectConfig.id.equalsIgnoreCase(projectId)) {
                return curProjectConfig;
            }
        }
        return null;
    };
}