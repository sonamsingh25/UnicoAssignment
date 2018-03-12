package main.java.com.unico.soapWebService.impl;

import main.java.com.unico.processor.UnicoProcessor;
import main.java.com.unico.soapWebService.SoapService;

import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebMethod;

/*
 * Implementation class for SOAP Web Service
 */

@WebService(endpointInterface="main.java.com.unico.soapWebService.SoapService")
public class SoapServiceImpl implements SoapService{
	
	@Resource
    WebServiceContext wsctx;
	
	@SuppressWarnings("rawtypes")
	private boolean validateUser()
	{
	MessageContext mctx = wsctx.getMessageContext();

	   //get detail from request headers        
		Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        List userList = (List) http_headers.get("Username");
        List passList = (List) http_headers.get("Password");

        String username = "";
        String password = "";

        if(userList!=null){        	
        	username = userList.get(0).toString();
        }

        if(passList!=null){        	
        	password = passList.get(0).toString();
        }

        //Should validate username and password with database
        if (username.equals("admin") && password.equals("password")){
        	return true;
        }else{
        	return false;
        }
	}


	@WebMethod(operationName="getGcd")
	public int getGcd()
	{  
		if(validateUser())
		{
	     UnicoProcessor serv = new UnicoProcessor();		
	     return serv.getLargestCommonDivisor();
		}
		
		else
		{
			System.err.println("Invalid User");
		}
		
		return 0;
	}

	
	@WebMethod(operationName="getGcListFromDB")
	public Integer[] getGcdList() {
		if(validateUser())
		{
			UnicoProcessor serv = new UnicoProcessor();
		
		Integer[] arr = serv.getListOfGcd().stream().toArray(Integer[]::new);
		return arr;
		}
		
		else
		{
			System.err.println("Invalid User");
		}
		
		return null;
	}

	@WebMethod(operationName="getGcdSum")
	public int getGcdSum() {
		if(validateUser())
		{
			UnicoProcessor serv = new UnicoProcessor();
		return serv.getGcdSum();		
		}
		
		else
		{
			System.err.println("Invalid User");
		}
		
		return 0;
	}

}
