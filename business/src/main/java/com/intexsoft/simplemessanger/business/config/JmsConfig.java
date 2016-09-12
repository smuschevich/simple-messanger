package com.intexsoft.simplemessanger.business.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.intexsoft.simplemessanger.business.jms")
@PropertySource({"classpath:jms.properties"})
public class JmsConfig
{
}
