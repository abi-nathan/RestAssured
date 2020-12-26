import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC002A_POST {
	
	
	
	
	@Test
	public void RegistrationSuccessful()
	{		
		RestAssured.baseURI ="https://reqres.in/api/";
		RequestSpecification httprequest = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		
		requestParams.put("name", "Tendulkar"); 
		requestParams.put("year", "2020");
		//requestParams.put("UserName", "singh@gmail.com");
		//requestParams.put("Password", "cricket100");
		//requestParams.put("color",  "browm");
		
		httprequest.header("Content-Type","application/json ");
		httprequest.body(requestParams.toJSONString());
		
		Response response = httprequest.post("users");
		System.out.println(response.getBody().asPrettyString());
				
		//response.prettyPrint();

		int statusCode = response.getStatusCode();
		System.out.println("The status code received is "+statusCode);
		Assert.assertEquals(statusCode, 201);
		
		
	}

}
