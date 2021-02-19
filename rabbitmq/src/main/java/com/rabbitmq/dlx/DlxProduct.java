package com.rabbitmq.dlx;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import com.rabbitmq.client.*;

/**
 * @author guozhenhua
 * @date 2019/01/08
 */
public class DlxProduct {

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

        String exChangeName="test_dlx_exchange";
        String routerKey="dlx.save";


        for (int i=0;i<5;i++) {
            AMQP.BasicProperties.Builder builder=new  AMQP.BasicProperties.Builder();
            builder.deliveryMode(2).contentEncoding("UTF-8").expiration("10000");
            String msg = "hell rabbitmq"+i;
            channel.basicPublish(exChangeName, routerKey, builder.build(), msg.getBytes());
        }

        //关闭连接

        channel.close();
        connection.close();
    }
}
