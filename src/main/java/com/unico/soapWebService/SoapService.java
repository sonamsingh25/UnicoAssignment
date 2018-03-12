/**
 * 
 */
package main.java.com.unico.soapWebService;

/**
 * Interface for SOAP Web service
 *
 */

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
public interface SoapService {
	
	@WebMethod()
	public int getGcd();	
	
	@WebMethod()
	public Integer[] getGcdList();
	
	@WebMethod()
	public int getGcdSum();
	

}
