// 注册并提供一个 RestTemplate Bean，方便其他地方用来发送 HTTP 请求。
// 调用外部接口
package com.ruoyi.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
