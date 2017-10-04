package com.springintegration.service;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

@MessageEndpoint(value="msgService")
public class MessageService {

	@ServiceActivator(inputChannel="msgChannel", autoStartup="true")
	public Message<String> processMsg(Message<String> msg){
		
		
		String str = msg.getPayload();
		//System.out.println(str);
		Message<String> newMsg = MessageBuilder.withPayload(str +"Balram").build();
		return newMsg;
	}
}
