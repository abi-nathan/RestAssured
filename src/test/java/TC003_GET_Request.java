import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC003_GET_Request {
	
	 @Test //annotations which control the execution flow of methods
	 void getrequest() 
	 {
		
		 
		 RestAssured.baseURI = "https://reqres.in/api/2";
		 
		 
		 RequestSpecification httpRequest = RestAssured.given();
		 
		 
		 Response response = httpRequest.request(Method.GET,"2");
		 System.out.println("Response is " +response);
		 
		 
		 
		 String responseBody=response.getBody().asString();
		 System.out.println( "The Response body is "+responseBody);
		 response.prettyPrint();
		 
		
		 int statuscode = response.getStatusCode();
		 System.out.println("The Status code is "+statuscode);
		 Assert.assertEquals(statuscode, 200);
	 }
}
