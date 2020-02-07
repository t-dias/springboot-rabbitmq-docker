package com.example.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqApplication.class, args);
    }

    @Value("${exchange.name}")
    private String exchangeName;

    @Value("${queue.name}")
    private String queueName;

    @Bean
    Queue queue() {
        return new Queue(queueName, true);
    }

    @Bean
    FanoutExchange fanout() {
        return new FanoutExchange(exchangeName);
    }

    @Bean
    Binding binding(Queue queue, FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
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
