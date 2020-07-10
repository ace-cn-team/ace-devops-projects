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
        return EnvironmentEnum.values()
                .toList()
                .stream()
                .map(p -> p.id)
                .collect(Collectors.toList())
                .join(",");

    }


}
