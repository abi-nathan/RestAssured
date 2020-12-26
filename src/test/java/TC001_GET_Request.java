
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC001_GET_Request {
	
	
	 @Test //annotations which control the execution flow of methods
	 void getweatherDetails() 
	 {
		//Specify the base URL to the RESTful web service
		 
		 RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
		 
		 //REquest Object
		 RequestSpecification httpRequest = RestAssured.given();
		 
		 //Response Object
		 Response response = httpRequest.request(Method.GET,"2");
		 System.out.println("Response is " +response);
		 
		 //print response in console window. the value from response object is of jason format. 
		// need to convert to string
		 //response contains status code, status line, body,time,header etc.,but we need only body here.
		 
		 String responseBody=response.getBody().asString();
		 System.out.println( "The Response body is "+responseBody);
		 
		 //status code validation
		 int statuscode = response.getStatusCode();
		 System.out.println("The Status code is "+statuscode);
		 Assert.assertEquals(statuscode, 200);
		 
		 //statusline validation
		String statusline =  response.getStatusLine();
		System.out.println("The StatusLine is " + statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		 
		 String servertype = response.header("Server");
		 System.out.println("Server value is -" +servertype);
	 }
}
