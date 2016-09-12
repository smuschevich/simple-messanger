package com.intexsoft.simplemessanger.client.config;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.intexsoft.simplemessanger.business.config.JmsConfig;
import com.intexsoft.simplemessanger.webservice.ProtocolWebService;

@Configuration
@Import({JmsConfig.class})
public class ClientWebServiceConfig
{
	@Bean
	public ProtocolWebService protocolWebService()
	{
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(ProtocolWebService.class);
		factory.setAddress("http://localhost:8080/services/protocol");
		return (ProtocolWebService) factory.create();
	}
}
