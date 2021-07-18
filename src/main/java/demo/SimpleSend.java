package demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

public class SimpleSend {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleSend.class);

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
            String msg = "hello world.";
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes(StandardCharsets.UTF_8));
            LOGGER.info("send msg success.");
            channel.close();
            connection.close();
        } catch (Exception e) {
            LOGGER.error("connect failed. error msg: {}", e.getMessage());
        }
    }
}
