package com.rabbitmq.return_listener;

import java.io.IOException;
import com.rabbitmq.client.*;

/**
 * @author guozhenhua
 * @date 2019/01/18
 */
public class Consumer {


    public static void main(String[] args) throws Exception {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setVirtualHost("/");
        connectionFactory.setPort(5672);
        connectionFactory.setHost("127.0.0.1");

        Connection connection = connectionFactory.newConnection();
        final Channel channel = connection.createChannel();

        String exchange = "test_return_exchange";
        String routerKey = "return.#";
        String routerKeyError="abc.save";
        String queueName="test_return_queue";

        channel.exchangeDeclare(exchange, "topic",true , false, null);
        channel.queueDeclare(queueName, true, false, false, null);
        channel.queueBind(queueName, exchange, routerKey);

        channel.basicConsume(queueName,false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {

                String routingKey = envelope.getRoutingKey();
                String contentType = properties.getContentType();
                long deliveryTag = envelope.getDeliveryTag();
                System.out.println("-----"+new String(body)+"---------"+routingKey+contentType);

                channel.basicAck(deliveryTag, false);

            }
        });
    }
}
