package com.sparta.limited.order_service.application.config;

import com.sparta.limited.common_module.config.AuditorAwareConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AuditorAwareConfig.class)
public class OrderAuditConfig {

}
