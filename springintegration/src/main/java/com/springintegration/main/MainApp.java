package com.springintegration.main;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

public class MainApp {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("springbean.xml");
		MessageChannel msgChannel = context.getBean("msgChannel", MessageChannel.class);
		Message<String> msg = MessageBuilder.withPayload("Hello").build();
		msgChannel.send(msg);
	}

}
