import ace.devops.module.project.ProjectDefaultContext
import ace.devops.module.project.service.JenkinsProjectFacadeService
import ace.devops.module.project.service.ProjectService
import groovy.json.JsonOutput
import org.junit.Test

/**
 * @author Caspar* @contract 279397942@qq.com
 * @create 2020/7/9 15:56
 * @description
 */

class ProjectServiceTest {

    @Test
    void initProjectService() {
        ProjectDefaultContext projectDefaultContext = new ProjectDefaultContext();
        ProjectService projectService = projectDefaultContext.projectService;
        println(JsonOutput.toJson(projectService.findAll()));
        JenkinsProjectFacadeService jenkinsProjectFacadeService = projectDefaultContext.jenkinsProjectFacadeService;
        println(jenkinsProjectFacadeService.getChoiceFromProjects());
        def project = projectService.findAll().stream().findFirst().get();
        println("jenkinsProjectFacadeService.getProjectWorkSpace:${jenkinsProjectFacadeService.getProjectWorkSpace(project)}");
        println("jenkinsProjectFacadeService.getProjectPomFileAbsolutePath:${jenkinsProjectFacadeService.getProjectPomFileAbsolutePath(project)}");
    }
}
