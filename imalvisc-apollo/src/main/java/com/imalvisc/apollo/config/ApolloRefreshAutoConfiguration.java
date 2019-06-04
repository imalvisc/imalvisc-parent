package com.imalvisc.apollo.config;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName ApolloRefreshAutoConfiguration
 * @Description Apollo刷新监听自动配置
 * @motto 学会编程而不是学会编码！
 * @date 2019-06-04 21:06
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Slf4j
@Configuration
public class ApolloRefreshAutoConfiguration {

    /**
     * 执行监听
     *
     * @param refreshScope
     * @return
     */
    @Bean
    public Object doListen(RefreshScope refreshScope) {
        String[] namespaces = Namespaces.namespaces;
        if (namespaces != null && namespaces.length > 0) {
            Config config;
            for (String namespace : namespaces) {
                config = ConfigService.getConfig(namespace);
                if (config != null) {
                    config.addChangeListener(changeEvent -> {
                        for (String key : changeEvent.changedKeys()) {
                            ConfigChange change = changeEvent.getChange(key);
                            log.info("Apollo Found change - namespace: {}, key: {}, oldValue: {}, newValue: {}, changeType: {}",
                                    changeEvent.getNamespace(), change.getPropertyName(), change.getOldValue(), change.getNewValue(), change.getChangeType());
                        }
                        //利用SpringCloud提供的RefreshScope来刷新SpringBoot的环境配置
                        refreshScope.refreshAll();
                    });
                }
            }
        }
        return null;
    }

}
