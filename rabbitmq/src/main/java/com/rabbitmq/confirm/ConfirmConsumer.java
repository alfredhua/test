package com.rabbitmq.confirm;

import java.io.IOException;
import com.rabbitmq.client.*;

/**
 * @author guozhenhua
 * @date 2019/01/09
 */
public class ConfirmConsumer {

    public static void main(String[] args) throws Exception{

        ConnectionFactory connectionFactory=new ConnectionFactory();

        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");

        Connection connection = connectionFactory.newConnection();

        final Channel channel = connection.createChannel();

        String queueName="confirm_queue";
        channel.basicConsume(queueName, true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String routingKey = envelope.getRoutingKey();
                String contentType = properties.getContentType();
                long deliveryTag = envelope.getDeliveryTag();
                System.out.println("-----"+new String(body)+routingKey+contentType);
                channel.basicAck(deliveryTag, false);

            }
        });


    }
}
