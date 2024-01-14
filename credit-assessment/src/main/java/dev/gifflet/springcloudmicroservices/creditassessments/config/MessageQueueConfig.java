package dev.gifflet.springcloudmicroservices.creditassessments.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageQueueConfig {

    @Value("${mq.queues.card-issuance}")
    private String queueName;

    @Bean
    public Queue queueCardIssuance() {
        return new Queue(queueName, true);
    }
}
