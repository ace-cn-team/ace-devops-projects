@Library("ace-devops-utils@master")
def work;
node {
    aceProjectConfig.test();
    echo aceProjectConfig.getAllProjects();
}