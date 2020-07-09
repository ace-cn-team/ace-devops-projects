@Library("ace-devops-utils@master")
import ace.devops.config;
node {
    config a = new config();
    a.k=2;
    echo a.k;
}