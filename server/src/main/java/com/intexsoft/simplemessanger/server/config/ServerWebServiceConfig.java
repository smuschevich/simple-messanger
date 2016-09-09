package com.intexsoft.simplemessanger.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.intexsoft.simplemessanger.webservice.config.WebServiceConfig;

@Configuration
@Import(WebServiceConfig.class)
@ImportResource({"classpath:META-INF/cxf/cxf.xml"})
public class ServerWebServiceConfig
{
}
