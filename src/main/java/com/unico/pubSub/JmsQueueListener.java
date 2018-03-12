package main.java.com.unico.pubSub;


import java.util.ArrayDeque;
import java.util.Deque;


import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/*
 * Used for Message Receving from a queue
 * Assumption - The server - tcp://localhost:61616 and the queue name are not there but assumed to be existent
 * 
 */

public class JmsQueueListener{
	
	public static Deque<Integer> qu = new ArrayDeque<Integer>();
	
	public void receiveMessage()
	{
	
	ConnectionFactory factory =  new ActiveMQConnectionFactory("tcp://localhost:61616"); 

			Connection con  = null;

			try {
				
				con = factory.createConnection();
			  Session session =  con.createSession(false, Session.AUTO_ACKNOWLEDGE);

			  Queue queue = session.createQueue("INPUT.QUEUE"); 
			  
			  MessageConsumer consumer = session.createConsumer(queue);
			  consumer.setMessageListener((MessageListener) this);

			  con.start();                                            
			  while (true) {                                     
			    Message msg = consumer.receive();                    
			    if (! (msg instanceof TextMessage))
			      throw new RuntimeException("Expected a TextMessage");
			    TextMessage tm = (TextMessage) msg;
			      qu.add(Integer.parseInt(tm.getText()));
			  }			  
			}
			catch(JMSException e)
			{
				System.err.println("Exception while reading message from the queue "+e.getMessage());
			}
			                              
			

}
	

}




