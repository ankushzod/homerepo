package com.springintegration.service;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

@MessageEndpoint(value = "newMsgService")
public class NewMessageService {

	@ServiceActivator(inputChannel = "newMsgChannel", autoStartup = "true")
	public void newProcessMsg(Message<String> msg) {

		System.out.println(msg.getPayload());
	}

}
