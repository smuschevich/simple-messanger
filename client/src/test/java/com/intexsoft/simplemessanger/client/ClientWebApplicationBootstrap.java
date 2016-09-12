package com.intexsoft.simplemessanger.client;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.util.Assert;

import com.intexsoft.simplemessanger.business.jms.JmsListenerContainer;
import com.intexsoft.simplemessanger.client.config.ClientWebApplicationInitializer;
import com.intexsoft.simplemessanger.webservice.ProtocolWebService;
import com.intexsoft.simplemessanger.webservice.vo.JmsDescriptor;

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
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ClientWebApplicationBootstrap.class, args);
		ProtocolWebService protocol = applicationContext.getBean(ProtocolWebService.class);
		Assert.isTrue(protocol.sayHello());
		JmsDescriptor jmsDescriptor = protocol.getJmsDescriptor();
		Assert.notNull(jmsDescriptor);
		JmsListenerContainer listener = applicationContext.getBean(JmsListenerContainer.class, jmsDescriptor.getBrokerUrl(),
				jmsDescriptor.getDestinationName());
		Assert.notNull(listener);
	}
}
