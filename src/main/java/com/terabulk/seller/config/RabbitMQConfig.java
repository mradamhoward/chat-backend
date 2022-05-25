package com.terabulk.seller.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Value("${terabulk.rabbitmq.queue}")
	String queueName;

	@Value("${terabulk.rabbitmq.exchange}")
	String exchange;

	@Value("${terabulk.rabbitmq.routingkey}")
	private String routingkey;
	
	private String routingkeynotif = "notif";
	
	@Value("${terabulk.rabbitmq.queue.notifications}")
	private String qMsg;

	@Bean
	Queue queue1() {
		return new Queue(qMsg, false);
	}
	
	@Bean
	Queue queue2() {
		return new Queue(queueName, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(exchange);
	}

	@Bean
	Binding binding1(TopicExchange exchange) {
	    return BindingBuilder.bind(queue1()).to(exchange).with(queue1().getName());
	}

	@Bean
	Binding binding2(TopicExchange exchange) {
	    return BindingBuilder.bind(queue2()).to(exchange).with(queue2().getName());
	}
	
	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public AmqpTemplate rabbitTemplateBean(ConnectionFactory connectionFactory) {	
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jsonMessageConverter());
		return rabbitTemplate;
	}	
}