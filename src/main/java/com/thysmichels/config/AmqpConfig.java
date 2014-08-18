package com.thysmichels.config;

import com.thysmichels.model.Todo;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.*;
import org.springframework.amqp.rabbit.core.*;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.transaction.RabbitTransactionManager;
import org.springframework.amqp.support.converter.*;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.task.*;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.Executors;

/**
 * Created by tmichels on 8/16/14.
 */

@Configuration
@PropertySource("classpath:services.properties")
@EnableTransactionManagement
public class AmqpConfig {

    private String customersQueueAndExchangeName = "todo";

    @Bean
    public TaskScheduler taskScheduler() {
        return new ConcurrentTaskScheduler(Executors.newScheduledThreadPool(10));
    }

    @Bean
    public SimpleAsyncTaskExecutor taskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(MessageConverter messageConverter, ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }

    @Bean
    public RabbitTransactionManager amqpTransactionManager(ConnectionFactory connectionFactory) {
        return new RabbitTransactionManager(connectionFactory);
    }

    @Bean
    public JsonMessageConverter jsonMessageConverter() {
        return new JsonMessageConverter();
    }

    @Bean
    public ConnectionFactory connectionFactory(Environment environment) {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setUsername(environment.getProperty("amqp.broker.username"));
        cachingConnectionFactory.setPassword(environment.getProperty("amqp.broker.password"));
        cachingConnectionFactory.setHost(environment.getProperty("amqp.broker.host"));
        cachingConnectionFactory.setPort(environment.getProperty("amqp.broker.port", Integer.class));
        return cachingConnectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public Queue customerQueue(AmqpAdmin amqpAdmin) {
        Queue q = new Queue(this.customersQueueAndExchangeName);
        amqpAdmin.declareQueue(q);
        return q;
    }

    @Bean
    public DirectExchange customerExchange(AmqpAdmin amqpAdmin) {
        DirectExchange directExchange = new DirectExchange(customersQueueAndExchangeName);
        amqpAdmin.declareExchange(directExchange);
        return directExchange;
    }

    @Bean
    public Binding marketDataBinding(Queue customerQueue, DirectExchange directExchange) {
        return BindingBuilder
                .bind(customerQueue)
                .to(directExchange)
                .with(this.customersQueueAndExchangeName);
    }

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(TaskExecutor taskExecutor, Queue customerQueue, final JsonMessageConverter jsonMessageConverter, ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer smlc = new SimpleMessageListenerContainer();
        smlc.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                Todo customer = (Todo) jsonMessageConverter.fromMessage(message);
                System.out.println("Received new customer " + customer.toString());
            }
        });
        smlc.setTaskExecutor(taskExecutor);
        smlc.setAutoStartup(false);
        smlc.setQueues(customerQueue);
        smlc.setConcurrentConsumers(10);
        smlc.setConnectionFactory(connectionFactory);
        return smlc;
    }
}
