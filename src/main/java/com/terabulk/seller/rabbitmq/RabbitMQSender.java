package com.terabulk.seller.rabbitmq;

import com.terabulk.seller.models.Notification;
import com.terabulk.seller.models.WebSocketChatMessage;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
	@Autowired
	private AmqpTemplate rabbitTemplate;
	@Value("${terabulk.rabbitmq.exchange}")
	private String exchange;
	@Value("${terabulk.rabbitmq.routingkey}")
	private String routingkey;
	//use q name as rk
	@Value("${terabulk.rabbitmq.queue}")
	String queueName;
	private String q = "terabulk.notifications";
	private final String qMsg = "terabulk.notifications";
	public void send(WebSocketChatMessage company) {
		rabbitTemplate.convertAndSend(exchange, queueName, company);
		System.out.println("Send msg = " + company.getContent());
	}
	public void broadcastNotification(Notification n) {
		rabbitTemplate.convertAndSend(exchange, qMsg,n);
		System.out.println("Send msg notificatio = " + n.getMessage());
	}
}