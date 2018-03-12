package main.java.com.unico.pubSub;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;

import javax.jms.Session;

import javax.naming.NamingException;

import org.apache.activemq.ActiveMQConnectionFactory;

/*
 * Used for Message Publishing to a queue
 * Assumption - The server - tcp://localhost:61616 and the queue name are not there but assumed to be existent
 * Singleton Class - Only one instance available to all the threads
 */

public class JmsQueuePublisher {	
	
	public static volatile JmsQueuePublisher pub = null;
	
	private JmsQueuePublisher()
	{
		
	}
	
	public static JmsQueuePublisher getInstance()
	{
		synchronized(JmsQueuePublisher.class)
		{
			if(pub == null)
				pub = new JmsQueuePublisher();
		}
		
		return pub;
	}
	
	
	
	public void sendMessage(String str) throws JMSException,NamingException {
		
		ConnectionFactory factory =  new ActiveMQConnectionFactory("tcp://localhost:61616"); 

		Connection con  = null;

			
			con = factory.createConnection();
		  Session session = 
		      con.createSession(false, Session.AUTO_ACKNOWLEDGE);

		  Queue queue = session.createQueue("INPUT.QUEUE"); 
		  MessageProducer producer = session.createProducer(queue);
		  Message msg = session.createTextMessage(str); 
		  producer.send(msg);
		  con.start();		  
		     
	
}


}
