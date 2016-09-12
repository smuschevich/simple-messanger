package com.intexsoft.simplemessanger.webservice.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.intexsoft.simplemessanger.webservice.ProtocolWebService;
import com.intexsoft.simplemessanger.webservice.vo.JmsDescriptor;

@Component
@WebService(endpointInterface = "com.intexsoft.simplemessanger.webservice.ProtocolWebService")
public class ProtocolWebServiceImpl implements ProtocolWebService
{
	@Value("${jms.broker.url}")
	private String brokerUrl;
	@Value("${jms.queue}")
	private String destinationName;

	@Override
	public boolean sayHello()
	{
		return true;
	}

	@Override
	public JmsDescriptor getJmsDescriptor()
	{
		JmsDescriptor jmsDescriptor = new JmsDescriptor();
		jmsDescriptor.setBrokerUrl(brokerUrl);
		jmsDescriptor.setDestinationName(destinationName);
		return jmsDescriptor;
	}
}
