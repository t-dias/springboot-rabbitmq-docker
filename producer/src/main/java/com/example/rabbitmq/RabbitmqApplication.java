package com.example.rabbitmq;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableRetry
@EnableAsync
public class RabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqApplication.class, args);
    }

    @Value("${exchange.name}")
    private String exchangeName;

    @Bean
    FanoutExchange fanout() {
        return new FanoutExchange(exchangeName);
    }

    /**
     * Declare all queue to a exchange
     * @return
     */
	/*@Bean
	public Declarables topicBindings() {
		Queue queue = new Queue(queueName, true);
		FanoutExchange fanoutExchange = new FanoutExchange(exchangeName);

		return new Declarables(
				queue,
				fanoutExchange,
				BindingBuilder
						.bind(queue)
						.to(fanoutExchange));
	}*/

}
