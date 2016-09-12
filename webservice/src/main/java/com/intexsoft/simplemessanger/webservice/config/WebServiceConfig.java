package com.intexsoft.simplemessanger.webservice.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.intexsoft.simplemessanger.business.config.BusinessConfig;
import com.intexsoft.simplemessanger.webservice.ProtocolWebService;

@Configuration
@Import({BusinessConfig.class})
@ComponentScan(basePackages = {"com.intexsoft.simplemessanger.webservice.impl"})
public class WebServiceConfig
{
	@Autowired
	@Qualifier(Bus.DEFAULT_BUS_ID)
	private Bus bus;
	@Autowired
	private ProtocolWebService protocolWebService;

	@Bean
	public Endpoint protocolEndPoint()
	{
		EndpointImpl endpoint = new EndpointImpl(bus, protocolWebService);
		endpoint.publish("/protocol");
		return endpoint;
	}
}
