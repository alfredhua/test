package com.rabbitmq.limit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author guozhenhua
 * @date 2019/01/08
 */
public class LimitProduct {

    public static void main(String[] args) throws IOException, TimeoutException {

        //创建连接工厂
        ConnectionFactory connectionFactory=new ConnectionFactory();

        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        //创建连接
        Connection connection = connectionFactory.newConnection();

        //创建channel
        Channel channel = connection.createChannel();

        String exChangeName="test_qos_exchange";
        String routerKey="qos.#";
        //声名一个队列


        for (int i=0;i<5;i++) {
            String msg = "hell rabbitmq"+i;
            channel.basicPublish(exChangeName, routerKey, null, msg.getBytes());
        }

        //关闭连接

        channel.close();
        connection.close();
    }
}
