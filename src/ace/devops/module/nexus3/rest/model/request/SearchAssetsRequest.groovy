package ace.devops.module.nexus3.rest.model.request

/**
 * @author Caspar* @contract 279397942@qq.com
 * @create 2020/7/12 12:40
 * @description
 */
class SearchAssetsRequest {
    /**
     * 只有四个值:version,group,name,repository
     */
    String sort;
    /**
     * 值有：desc,asc
     */
    String direction;
    String mavenBaseVersion;
    String mavenArtifactId;
}
