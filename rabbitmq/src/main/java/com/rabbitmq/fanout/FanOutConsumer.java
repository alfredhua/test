package com.rabbitmq.fanout;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author guozhenhua
 * @date 2019/01/08
 */
public class FanOutConsumer {


    public  static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory connectionFactory=new ConnectionFactory();

        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        //创建连接
        Connection connection = connectionFactory.newConnection();

       final Channel channel = connection.createChannel();

        //声名一个队列

        String exchangeName="fanout_exchange_a";
        String queueName="fanout_queue_a";
        channel.exchangeDeclare(exchangeName, "fanout", true, false, null);
        channel.queueDeclare(queueName, true, false, false, null);

        channel.queueBind( queueName, exchangeName,"");
        //设置channel
        channel.basicConsume(queueName,false,new DefaultConsumer(channel){
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
