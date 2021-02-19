package com.rabbitmq.return_listener;

import java.io.IOException;
import com.rabbitmq.client.*;

/**
 * @author guozhenhua
 * @date 2019/01/18
 */
public class Producer {


    public static void main(String[] args) throws Exception{

        ConnectionFactory connectionFactory=new ConnectionFactory();

        connectionFactory.setVirtualHost("/");
        connectionFactory.setPort(5672);
        connectionFactory.setHost("127.0.0.1");

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        String exchange="test_return_exchange";
        String routerKey="return.save";
        String routerKeyError="abc.save";

        String msg="Hello RabbitMq";
        channel.addReturnListener(new ReturnListener() {
            @Override
            public void handleReturn(int i, String s, String s1, String s2, AMQP.BasicProperties basicProperties, byte[] bytes)
                    throws IOException {

                System.out.println("--------handle return-------");

                System.out.println("--------replay code -------"+i);
                System.out.println("--------reply text-------"+s);
                System.out.println("--------exhcange -------"+s1);
                System.out.println("--------routerKey-------"+s2);
                System.out.println("--------basicProperties-------"+basicProperties);
                System.out.println("--------basicProperties-------"+bytes);


            }
        });

        channel.basicPublish(exchange,routerKeyError , true,null, msg.getBytes());




    }
}
