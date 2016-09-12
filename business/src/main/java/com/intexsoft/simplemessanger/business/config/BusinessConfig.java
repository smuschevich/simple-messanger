package com.intexsoft.simplemessanger.business.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({JmsConfig.class})
public class BusinessConfig
{
}
