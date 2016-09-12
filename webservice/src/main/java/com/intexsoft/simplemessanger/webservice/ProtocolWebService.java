package com.intexsoft.simplemessanger.webservice;

import javax.jws.WebService;

import com.intexsoft.simplemessanger.webservice.vo.JmsDescriptor;

@WebService
public interface ProtocolWebService
{
	boolean sayHello();

	JmsDescriptor getJmsDescriptor();
}
