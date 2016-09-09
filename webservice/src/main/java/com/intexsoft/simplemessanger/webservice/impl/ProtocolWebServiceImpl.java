package com.intexsoft.simplemessanger.webservice.impl;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.intexsoft.simplemessanger.webservice.ProtocolWebService;

@Component
@WebService(endpointInterface = "com.intexsoft.simplemessanger.webservice.ProtocolWebService")
public class ProtocolWebServiceImpl implements ProtocolWebService
{
	@Override
	public boolean sayHello()
	{
		return true;
	}
}
