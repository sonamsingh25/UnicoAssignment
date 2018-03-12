package main.java.com.unico.processor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import main.java.com.unico.dao.ServiceDao;
import main.java.com.unico.dao.impl.ServiceDaoImpl;
import main.java.com.unico.pubSub.JmsQueueListener;

/*
 * The Service class interacting with the DAO interface as well as the Publisher-Subscriber interface
 * 
 */


public class UnicoProcessor {
	 
         public List<Integer> getInputList()
         {
        	 ServiceDao serviceDao = new ServiceDaoImpl();
        	 List<Integer> inputNumberList = new ArrayList<Integer>();
        	 
        	 try {
			      inputNumberList.addAll(serviceDao.getInputNumbers());
			} catch (Exception e) {
				
				System.err.println("Error while getting the list from the database"+e);
			}
        	 
        	 return inputNumberList;      	 
          
        	 
         }
         
         
         public synchronized int getLargestCommonDivisor()
         {       	
        	
        	if(JmsQueueListener.qu.size()> 0)
        	{
        	Set<Integer> divSet = new  HashSet<Integer>();        	
        	
        	int i = JmsQueueListener.qu.remove();
        	int d = JmsQueueListener.qu.remove();
        	
        	for (int j =2; j < Math.min(i, d); j++ )
        	{
        		if(i%j == 0 && d%j ==0)
        			divSet.add(j);
        	}
        	
        	return Collections.max(divSet);
        	}
        	
        	else
        		return 0;
        	
         }
         
         
         
         public List<Integer> getListOfGcd()
         {
        	 List<Integer> listGcd = new ArrayList<Integer>();
        	 
        	 ServiceDao serviceDao = new ServiceDaoImpl();
        	 
        	 try {
				listGcd.addAll(serviceDao.getListGcd());
			} catch (Exception e) {
				System.err.println("Exception while getting list of divisors "+e);
				
			}        	 
        	 
        	 return listGcd;
         }
         
         
         public int getGcdSum()
         {
        	int sum = 0;       	 
        	 
        	 ServiceDao serviceDao = new ServiceDaoImpl();
        	 
        	try {
				return serviceDao.getListGcd().stream().mapToInt(i -> i).sum();
			} catch (Exception e) {
				System.err.println("Exception while getting the data for Greatest Common Divisors from Database "+e);
			}
        	
        	return sum;
        	 
         }

}
