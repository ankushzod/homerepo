package com.springintegration.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

public class QueueChannelTest {
	private ApplicationContext ctx = null;
	private MessageChannel qChannel = null;

	public QueueChannelTest() throws BeansException {
		ctx = new ClassPathXmlApplicationContext("channels-beans.xml");
		qChannel = ctx.getBean("q-channel", MessageChannel.class);
	}

	public void receive() {
		// This method receives a message, however it blocks
		// indefinitely until it finds a message
		// Message m = ((QueueChannel) qChannel).receive();
		// This method receives a message, however it exists
		// within the 10 seconds even if doesn't find a message
		Message m = ((QueueChannel) qChannel).receive(10000);
		System.out.println("Payload: " + m.getPayload());
	}
}