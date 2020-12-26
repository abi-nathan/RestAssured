import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {

	@Test
	void Registration()
	{
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestParam = new JSONObject();
		
		requestParam.put("name", "Peteraabby");//put method adds parameters to the request 
		//requestParam.put("username", "Peteraabbyabc1");
		//requestParam.put("email", "Peteraabbyabc@gmail.com");
        
		
		httpRequest.header("Content-Type", "application/json");//sending the above parameters in jason format(content type)
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST,"/create");//attach above data to the request
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is " +responseBody);
		
		//Status code validation
		int statuscode = response.getStatusCode();
		System.out.println("The status code is " +statuscode);
		Assert.assertEquals(statuscode,201);
		
		//Success code validation
		/*String successcode = response.jsonPath().get("SuccessCode");
		System.out.println("The Successcode is " +successcode);
		Assert.assertEquals(successcode,"OPERATION_SUCCESS");*/
		
	}
}
