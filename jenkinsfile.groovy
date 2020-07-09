@Library("ace-devops-utils@master")
import ace.devops.config;
node {
    config a = new config();
    echo a.allProjectConfigs;
}