package org.example.service;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Service;

@Service
public class MessageReceiverService {
    private static String MQ_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String MQ_SUBJECT = "JMS_TEST";
    private Connection connection;
    private Session session;

    public MessageReceiverService() {
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(MQ_URL);
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void receive() throws JMSException {
        Destination destination = session.createQueue(MQ_SUBJECT);

        // MessageConsumer is used for receiving (consuming) messages
        MessageConsumer consumer = session.createConsumer(destination);

        while (true) {
            // Here we receive the message.
            Message message = consumer.receive();
            // We will be using TestMessage in our example. MessageProducer sent us a TextMessage
            // so we must cast to it to get access to its .getText() method.
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                System.out.println("Received message '" + textMessage.getText() + "'");
            }
        }

    }

    public void close(){
        try {
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}