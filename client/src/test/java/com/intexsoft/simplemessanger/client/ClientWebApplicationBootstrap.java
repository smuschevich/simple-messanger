package com.intexsoft.simplemessanger.client;

import java.io.File;

import org.apache.tomcat.websocket.server.WsSci;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.intexsoft.simplemessanger.client.config.ClientWebApplicationInitializer;

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
		// enable WS SCI scanning for embedded Tomcat, it is required for web sockets 
		factory.addContextCustomizers(c -> c.addServletContainerInitializer(new WsSci(), null));
		return factory;
	}

	public static void main(String[] args)
	{
		SpringApplication.run(ClientWebApplicationBootstrap.class, args);
		/*ConfigurableApplicationContext applicationContext = SpringApplication.run(ClientWebApplicationBootstrap.class, args);
		ProtocolWebService protocol = applicationContext.getBean(ProtocolWebService.class);
		Assert.isTrue(protocol.sayHello());
		JmsDescriptor jmsDescriptor = protocol.getJmsDescriptor();
		Assert.notNull(jmsDescriptor);
		JmsListenerContainer listener = applicationContext.getBean(JmsListenerContainer.class, jmsDescriptor.getBrokerUrl(),
				jmsDescriptor.getDestinationName());
		Assert.notNull(listener);*/
	}
}
