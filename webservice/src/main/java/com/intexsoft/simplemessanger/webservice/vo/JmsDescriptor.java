package com.intexsoft.simplemessanger.webservice.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class JmsDescriptor
{
	@XmlElement(required = true)
	private String brokerUrl;
	@XmlElement(required = true)
	private String destinationName;

	public String getBrokerUrl()
	{
		return brokerUrl;
	}

	public void setBrokerUrl(String brokerUrl)
	{
		this.brokerUrl = brokerUrl;
	}

	public String getDestinationName()
	{
		return destinationName;
	}

	public void setDestinationName(String destinationName)
	{
		this.destinationName = destinationName;
	}
}
