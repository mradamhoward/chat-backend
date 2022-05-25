package com.terabulk.seller.rabbitmq;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

@Component
class Customizer {

    Customizer(GenericApplicationContext context, CachingConnectionFactory cf,
            SimpleRabbitListenerContainerFactory factory) {
        factory.setContainerCustomizer(container -> {
            CachingConnectionFactory newCf = new CachingConnectionFactory(cf.getRabbitConnectionFactory());
            String name = "cf." + container.getQueueNames()[0];
            newCf.setConnectionNameStrategy(c -> name);
            // set any other CCF properties you need
            context.registerBean(name, CachingConnectionFactory.class, () -> newCf);
            context.getBean(name); // initialize
            container.setConnectionFactory(newCf);
        });
    }
}