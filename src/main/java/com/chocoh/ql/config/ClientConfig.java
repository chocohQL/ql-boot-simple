package com.chocoh.ql.config;

import com.chocoh.ql.utils.EmailClient;
import com.chocoh.ql.utils.OssClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chocoh
 * @createTime 2024-01-28 23:02
 */
@Configuration
public class ClientConfig {
    @Bean
    public EmailClient emailClient() {
        return new EmailClient();
    }

    @Bean
    public OssClient ossClient() {
        return new OssClient();
    }
}
