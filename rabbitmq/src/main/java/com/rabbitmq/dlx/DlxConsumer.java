package com.rabbitmq.dlx;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import com.rabbitmq.client.*;

/**
 * @author guozhenhua
 * @date 2019/01/08
 */
public class DlxConsumer {


    public  static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory connectionFactory=new ConnectionFactory();

        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        //创建连接
        Connection connection = connectionFactory.newConnection();

       final Channel channel = connection.createChannel();

        //这就是一个普通的交换机和路由
        String exchangeName="test_dlx_exchange";
        String routerKey="dlx.#";
        String queueName="test_dlx_queue";
        //交换机名，队列类型，是否持久化，是否自动删除，参数
        channel.exchangeDeclare(exchangeName, "topic", true, false, null);
        //死信队列的声名
        Map<String,Object> arguments=new HashMap<>();
        arguments.put("x-dead-letter-exchange", "dlx.exchange");
        channel.queueDeclare(queueName, true, false, false, arguments);
        channel.queueBind(queueName, exchangeName, routerKey);

        //这是一个死信对列
        channel.exchangeDeclare("dlx.exchange","topic" ,true , false, null);
        channel.queueDeclare("dlx.queue", true, false, false,null );
        channel.queueBind("dlx.queue", "dlx.exchange", "#");

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
