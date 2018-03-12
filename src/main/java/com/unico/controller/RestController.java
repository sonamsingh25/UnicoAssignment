package main.java.com.unico.controller;

import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import main.java.com.unico.processor.UnicoProcessor;
import main.java.com.unico.pubSub.JmsQueuePublisher;


/*
 * Class for the REST Web Service
 * @Path /unico
 * Has two methods - push and list
 * push - pushes the input value to an ActiveMQ
 * list - lists all the numbers from a database *  
 */


@Path("/unico")
public class RestController {

	
	    @GET	
	    @Path("/push/{param1}/{param2}")		    
		public Response  push(@PathParam("param1") String i, @PathParam("param2") String d) {			
			JmsQueuePublisher pub = JmsQueuePublisher.getInstance();	
			try
			{
			
			pub.sendMessage(i);
			pub.sendMessage(d); 			
			
			String output =  "Success";
			
			return Response.status(200).entity(output).build();
			}
			catch(Exception e)
			{
				System.err.println(e.getMessage());
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Exception while adding numbers added to the queue:").build();
				
			}		
		}
	 
		
	  
		@GET
		@Path("/list")		
		public String list() {
	    	
	      UnicoProcessor serv = new UnicoProcessor();    	
	    	 
	    	 final ObjectMapper mapper = new ObjectMapper(); 
	    	 
	    	 String result="";
			try {
				result = mapper.writeValueAsString(serv.getInputList());
				
			} catch (JsonProcessingException e) {
				
				System.err.println("Error while parsing "+e.getMessage());
			}
	    	
	    	
	    	return result;
			
		}
		
		
	}


