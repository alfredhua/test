package com.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author guozhenhua
 * @date 2020/06/21
 */
@Configuration
@EnableConfigurationProperties
public class UrlConfig {


    @Value("${service-url.server}")
    private String serverUrl;

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }
}
