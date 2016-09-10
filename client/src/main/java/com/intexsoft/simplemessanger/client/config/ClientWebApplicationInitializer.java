package com.intexsoft.simplemessanger.client.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@Import(ClientWebServiceConfig.class)
public class ClientWebApplicationInitializer extends SpringBootServletInitializer
{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
	{
		return builder.sources(ClientWebApplicationInitializer.class);
	}
}
