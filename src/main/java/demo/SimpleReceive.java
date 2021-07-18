package demo;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

public class SimpleReceive {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleReceive.class);

    private static final String QUEUE_NAME = "queue_test";

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.31.90");
        factory.setPort(5672);
        factory.setUsername("test");
        factory.setPassword("123456");
        factory.setVirtualHost("/");
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            LOGGER.info("start receive message.");
            DeliverCallback deliverCallback = (consumerTag, message) -> {
                LOGGER.info(", message: {}", new String(message.getBody(), StandardCharsets.UTF_8));
            };
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});

        } catch (Exception e) {
            LOGGER.error("connect failed. error msg: {}", e.getMessage());
        }
    }
}
