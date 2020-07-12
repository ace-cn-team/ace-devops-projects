package ace.devops.module.jenkins.service

import ace.devops.module.jenkins.enums.EnvironmentEnum

import java.util.stream.Collectors


/**
 * @author Caspar* @contract 279397942@qq.com
 * @create 2020/7/10 9:55
 * @description
 */
class JenkinsEnvService {
    String getChoices() {
        StringBuffer sb = new StringBuffer();
        EnvironmentEnum.values().each { p ->
            sb.append(p.id);
            sb.append(",");
        };
        return sb.toString();
    }
}
