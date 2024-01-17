package com.rabbitmq.limit;
import com.rabbitmq.client.*;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author guozhenhua
 * @date 2019/01/08
 */
public class LimitConsumer {


    public  static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory connectionFactory=new ConnectionFactory();

        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        //创建连接
        Connection connection = connectionFactory.newConnection();

       final Channel channel = connection.createChannel();

       //声名交换机名
        String exchangeName="test_qos_exchange";
        String routerKey="qos.#";
        //声名一个队列
        String queueName="test_qos_queue";

        //交换机名，队列类型，是否持久化，是否自动删除，参数
        channel.exchangeDeclare(exchangeName, "topic", true, false, null);
        channel.queueDeclare(queueName, true, false, false, null);

        channel.queueBind(queueName, exchangeName, routerKey);
        //设置channel

        //1.限流
        //false是consumer级别
        channel.basicQos(0,1,false );
        // autoAck 一定为false
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
