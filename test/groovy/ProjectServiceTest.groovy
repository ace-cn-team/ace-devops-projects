import ace.devops.DefaultContext
import ace.devops.module.jenkins.enums.EnvironmentEnum
import ace.devops.module.jenkins.service.JenkinsEnvService
import ace.devops.module.jenkins.service.JenkinsProjectFacadeService
import ace.devops.module.project.service.ProjectService
import ace.devops.module.util.HttpUtils
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
        DefaultContext defaultContext = new DefaultContext();
        JenkinsEnvService jenkinsEnvService = defaultContext.jenkinsEnvService;
        ProjectService projectService = defaultContext.projectService;
        println(JsonOutput.toJson(projectService.findAll()));
        JenkinsProjectFacadeService jenkinsProjectFacadeService = defaultContext.jenkinsProjectFacadeService;
        println(jenkinsProjectFacadeService.getChoiceFromProjects());
        def project = projectService.findAll().stream().findFirst().get();
        println("jenkinsProjectFacadeService.getProjectWorkSpace:${jenkinsProjectFacadeService.getProjectWorkSpace(project)}");
        println("jenkinsProjectFacadeService.getProjectPomFileAbsolutePath:${jenkinsProjectFacadeService.getProjectPomFileAbsolutePath("", project)}");

        println("jenkinsProjectFacadeService.getProjectPomFileAbsolutePath:${jenkinsEnvService.getChoices()} ");
    }

    @Test
    void testNexus3Api() {
        //http://nexus3.ace.com:8081/service/rest/v1/search/assets?sort=version&direction=desc&maven.artifactId=ace-account-base-api-web
        Map<String, String> getParams = new HashMap<>();
        getParams.put("maven.artifactId", "ace-account-base-api-web")
        println(" HttpUtils.get:${HttpUtils.get("http://nexus3.ace.com:8081/service/rest/v1/search/assets", getParams)}");
    }
}
