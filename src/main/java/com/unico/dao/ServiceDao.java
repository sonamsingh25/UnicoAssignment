package main.java.com.unico.dao;

import java.util.List;

import javax.jms.TextMessage;

/*
 * DAO Class used by the services for fetching data from the database
 */

public interface ServiceDao {

		public List<Integer> getInputNumbers()  throws Exception;	
		
		public List<Integer> getListGcd() throws Exception;
		
		
		
	}
	
	


