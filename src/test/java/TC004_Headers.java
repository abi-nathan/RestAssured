import org.apache.tools.ant.taskdefs.email.Header;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_Headers {
	@Test
	
	public void validatingHeaders()
	{
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
		
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.request(Method.GET,"3");
		String body = response.getBody().asString();
		System.out.println("The body is = "+body);
		
		String headervalue1 = response.header("Content-Type");
		System.out.println("The content type is" +headervalue1);
		
		String headervalue2 = response.header("X-Ratelimit-Limit");
		System.out.println("The value is " +headervalue2);
		
		//getHeader works the same ways as header method
		
		String headervalue3 = response.getHeader("Pragma");
		System.out.println("The Pragma is "+headervalue3);
		
		//capturing all the headers from response
		Headers allHeaders = response.headers();
		
		
		for (io.restassured.http.Header header : allHeaders) {
			System.out.println("Header key is "+ header.getName() +"      " + "Header Value is " +header.getValue());
		}
		
		
	}
	
}
