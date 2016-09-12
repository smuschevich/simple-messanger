package com.intexsoft.simplemessanger.business.jms;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class JmsListenerContainer extends DefaultMessageListenerContainer
{
	private String brokerUrl;
	private String destinationName;

	private ActiveMQConnectionFactory jmsConnectionFactory;
	private JmsTransactionManager jmsTransactionManager;

	public JmsListenerContainer(String brokerUrl, String destinationName)
	{
		this.brokerUrl = brokerUrl;
		this.destinationName = destinationName;
		setConnectionFactory(getJmsConnectionFactory());
		setTransactionManager(getJmsTransactionManager());
		setDestinationName(this.destinationName);
	}

	private ConnectionFactory getJmsConnectionFactory()
	{
		if (jmsConnectionFactory == null)
		{
			jmsConnectionFactory = new ActiveMQConnectionFactory();
			jmsConnectionFactory.setBrokerURL(brokerUrl);
		}
		return jmsConnectionFactory;
	}

	private JmsTransactionManager getJmsTransactionManager()
	{
		if (jmsTransactionManager == null)
		{
			jmsTransactionManager = new JmsTransactionManager();
			jmsTransactionManager.setConnectionFactory(getJmsConnectionFactory());
		}
		return jmsTransactionManager;
	}
}
