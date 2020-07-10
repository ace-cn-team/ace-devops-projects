package ace.devops.module.jenkins.enums

/**
 * @author Caspar* @contract 279397942@qq.com
 * @create 2020/7/10 10:02
 * @description
 */
enum EnvironmentEnum {
    DEV("dev", "开发环境"),
    PRO("pro", "生产环境")
    ;
    String id;
    String name;

    private EnvironmentEnum(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
