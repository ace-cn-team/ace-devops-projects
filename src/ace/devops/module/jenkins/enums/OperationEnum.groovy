package ace.devops.module.jenkins.enums

/**
 * @author Caspar* @contract 279397942@qq.com
 * @create 2020/7/10 10:02
 * @description
 */
enum OperationEnum {
    DEPLOY("deploy", "部署"),
    GIT_CHECKOUT("git-checkout", "下载最新代码"),
    MVN_PACKAGE("mvn-package", "maven 打包"),
    ;
    String id;
    String name;

    private OperationEnum(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
