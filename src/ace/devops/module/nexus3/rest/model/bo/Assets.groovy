package ace.devops.module.nexus3.rest.model.bo

/**
 * @author Caspar* @contract 279397942@qq.com
 * @create 2020/7/12 12:29
 * @description nexus3上面的项目
 */
class Assets {
    /**
     * 下载地址
     */
    String downloadUrl;
    /**
     * nexus3服务上面的相对路径
     */
    String path;
    /**
     * id
     */
    String id;
    /**
     * 哪一个maven repository
     */
    String repository;
    /**
     * 格式,maven2
     */
    String format;
}
