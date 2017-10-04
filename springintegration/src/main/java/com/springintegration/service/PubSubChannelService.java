package com.springintegration.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

public class PubSubChannelService {
	
	private ApplicationContext ctx = null;
	private MessageChannel pubSubChannel = null;
	public PubSubChannelService() throws BeansException {
	ctx = new ClassPathXmlApplicationContext("channels-beans.xml");
	pubSubChannel = ctx.getBean("pubsub-channel", MessageChannel.class);
	}
	public void subscribe() {
	((PublishSubscribeChannel)pubSubChannel).subscribe(new TradeMessageHandler());
	}
	class TradeMessageHandler implements MessageHandler {
	public void handleMessage(Message<?> message) throws MessagingException {
		System.out.println("Handling Message:" + message);
	}
	}

}
