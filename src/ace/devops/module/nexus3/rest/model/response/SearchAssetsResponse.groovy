package ace.devops.module.nexus3.rest.model.response

import ace.devops.module.nexus3.rest.model.bo.Assets

/**
 * @author Caspar* @contract 279397942@qq.com
 * @create 2020/7/12 12:38
 * @description
 */
class SearchAssetsResponse {
    List<Assets> items;
    String continuationToken;

}
