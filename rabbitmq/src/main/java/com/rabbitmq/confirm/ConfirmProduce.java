package com.rabbitmq.confirm;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import com.rabbitmq.client.*;

/**
 * @author guozhenhua
 * @date 2019/01/09
 */
public class ConfirmProduce {

   public static void main(String[] args) throws IOException, TimeoutException {

       ConnectionFactory connectionFactory=new ConnectionFactory();

       connectionFactory.setHost("127.0.0.1");
       connectionFactory.setPort(5672);
       connectionFactory.setVirtualHost("/");

       Connection connection = connectionFactory.newConnection();

       Channel channel = connection.createChannel();
       channel.confirmSelect();
       String exchangeName="confirm_exchange";
       String queueName="confirm_queue";
       String routingKey="confirm.save";
       channel.exchangeDeclare(exchangeName, "topic", true, false, null);
       channel.queueDeclare(queueName, true, false, false, null);
       channel.queueBind(queueName, exchangeName, routingKey);

       for (int i=0;i<5;i++){
           String msg="confirm "+i;
           channel.basicPublish(exchangeName, routingKey, null, msg.getBytes());
       }

       channel.addConfirmListener(new ConfirmListener() {
           @Override
           public void handleAck(long l, boolean b) throws IOException {
               System.out.println("----------ok!-------");
           }

           @Override
           public void handleNack(long l, boolean b) throws IOException {
               System.out.println("----------not ok!-------");

           }
       });


   }

}
