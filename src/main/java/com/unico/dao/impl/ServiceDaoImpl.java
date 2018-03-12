package main.java.com.unico.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.util.ArrayList;
import java.util.List;

import main.java.com.unico.dao.ServiceDao;
import main.java.com.unico.util.DatabaseUtil;

/*
 * ServiceDaoImpl implements the ServiceDao interface
 * Provides the method implementations for the interface
 * Used for any queries made to the database
 * 
 */


public class ServiceDaoImpl implements ServiceDao{

	
		/*
		 * (non-Javadoc)
		 * @see main.java.com.unico.dao.ServiceDao#getInputNumbers()
		 * Gets the list of input numbers from the database
		 */
		public List<Integer> getInputNumbers() throws Exception {
			List<Integer> inputsList = new ArrayList<Integer>();
			Connection connection = null;
			
			try {
				connection = DatabaseUtil.getConnection();				
				PreparedStatement stmt = connection.prepareStatement("SELECT * FROM InputNumber");
				ResultSet rs = stmt.executeQuery();
				while(rs.next())
				{
					inputsList.add(rs.getInt("input"));
				}
			} catch (Exception e){
				e.printStackTrace();
			}
			
			return inputsList; 	
		}
		
		
		/*
		 * (non-Javadoc)
		 * @see main.java.com.unico.dao.ServiceDao#getListGcd()
		 * Gets the list of all greatest common divisors from the database
		 */
		public List<Integer> getListGcd() throws Exception {
			List<Integer> gcdList = null;
			Connection connection = null;
			try {
				connection = DatabaseUtil.getConnection();
				gcdList = new ArrayList<Integer>();
				PreparedStatement stmt = connection.prepareStatement("SELECT * FROM GCD");
				ResultSet rs = stmt.executeQuery();
				while(rs.next())
				{
					gcdList.add(rs.getInt("input"));
				}
			} catch (Exception e){
				e.printStackTrace();
			}
			return gcdList; 	
		}
	

}
