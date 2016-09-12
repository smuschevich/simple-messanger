package com.intexsoft.simplemessanger.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Import({ClientWebServiceConfig.class, ClientWebSocketConfig.class})
public class ClientWebApplicationInitializer extends SpringBootServletInitializer
{
	private static final String DISPATCHER_SERVLET_MAPPING = "/service/*";
	private static final String DISPATCHER_SERVLET_NAME = "DispatcherServlet";

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
	{
		return builder.sources(ClientWebApplicationInitializer.class);
	}

	@Bean
	public ServletRegistrationBean dispatcherServlet()
	{
		DispatcherServlet servlet = new DispatcherServlet(webApplicationContext);
		ServletRegistrationBean registration = new ServletRegistrationBean(servlet);
		registration.setName(DISPATCHER_SERVLET_NAME);
		registration.setAsyncSupported(true);
		registration.setLoadOnStartup(1);
		registration.addUrlMappings(DISPATCHER_SERVLET_MAPPING);
		return registration;
	}
}
