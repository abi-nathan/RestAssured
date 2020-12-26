import javax.json.JsonObject;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC006_PUT {
	
	@Test
	public void putrequest() {
		RestAssured.baseURI = "https://reqres.in/api/users/2";
		RequestSpecification httpRequest = RestAssured.given();
		                
		JSONObject jasonrequest = new JSONObject();
		jasonrequest.put("name","morpheus" );
		jasonrequest.put("job", "zion resident");
		
		httpRequest.header("Content-type",  "application/json");
		httpRequest.body(jasonrequest.toJSONString());
		
		Response response = httpRequest.request(Method.PUT,"/users/2");
		System.out.println("The body is " +response.getBody().asPrettyString());
		
		int statuscode = response.getStatusCode();
		System.out.println("The status code received is = " +statuscode);
		
		Assert.assertEquals(statuscode, 200);
		
		
	}

  
}
