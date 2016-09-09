package com.intexsoft.simplemessanger.client;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.intexsoft.simplemessanger.client.config.ClientWebApplicationInitializer;
import com.intexsoft.simplemessanger.webservice.ProtocolWebService;

@Import(ClientWebApplicationInitializer.class)
public class ClientWebApplicationBootstrap
{
	private static final File BASE_DIR = new File("build");
	private static final File WEBAPP_DIR_LOCATION = new File("src/main/webapp");
	private static final int PORT = 8081;

	@Bean
	public EmbeddedServletContainerFactory embeddedServletContainerFactory()
	{
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		factory.setBaseDirectory(BASE_DIR);
		factory.setDocumentRoot(WEBAPP_DIR_LOCATION);
		factory.setPort(PORT);
		return factory;
	}

	public static void main(String[] args)
	{
		ProtocolWebService protocol = SpringApplication.run(ClientWebApplicationBootstrap.class).getBean(ProtocolWebService.class);
		boolean res = protocol.sayHello();
		System.out.println(res);
	}
}
