@Library("ace-devops-utils@master")
import ace.devops.module.project.ProjectDefaultContext
import ace.devops.module.project.service.JenkinsProjectFacadeService
import ace.devops.module.project.service.ProjectService
import groovy.json.JsonOutput

def work;
node {
    ProjectDefaultContext projectDefaultContext = new ProjectDefaultContext();
    ProjectService projectService = projectDefaultContext.projectService;
    println(JsonOutput.toJson(projectService.findAll()));
    JenkinsProjectFacadeService jenkinsProjectFacadeService = projectDefaultContext.jenkinsProjectFacadeService;
    println(jenkinsProjectFacadeService.getChoiceFromProjects());
}