package ace.devops.module.jenkins.service

import ace.devops.module.jenkins.enums.EnvironmentEnum
import ace.devops.module.jenkins.enums.OperationEnum

import java.util.stream.Collectors


/**
 * @author Caspar* @contract 279397942@qq.com
 * @create 2020/7/10 9:55
 * @description
 */
class JenkinsOperationService {
    String getChoices() {
        return OperationEnum.values()
                .toList()
                .stream()
                .map(p -> p.id)
                .collect(Collectors.toList())
                .join(",");

    }


}
