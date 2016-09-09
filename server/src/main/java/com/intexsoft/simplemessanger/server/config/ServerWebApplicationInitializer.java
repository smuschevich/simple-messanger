package com.intexsoft.simplemessanger.server.config;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(ServerWebServiceConfig.class)
public class ServerWebApplicationInitializer extends SpringBootServletInitializer
{
	private static final String CXF_SERVLET_NAME = "CXFServlet";
	private static final String CXF_SERVLET_MAPPING = "/services/*";

	@Bean
	public ServletRegistrationBean dispatcherServlet()
	{
		CXFServlet servlet = new CXFServlet();
		ServletRegistrationBean registration = new ServletRegistrationBean(servlet);
		registration.setName(CXF_SERVLET_NAME);
		registration.setLoadOnStartup(1);
		registration.addUrlMappings(CXF_SERVLET_MAPPING);
		return registration;
	}
}
