import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC008_ValidatingJSONresponse {

	
	@Test
	public void jsonresponse()
	{
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
		
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.request(Method.GET,"1");
		
		String bodyresponse = response.getBody().asString();
		System.out.println("The body response is = "+bodyresponse);
		
		//Assert.assertEquals(bodyresponse.contains("Bret"), true);
		
		
		
		
		JsonPath jsonpathresponse = response.jsonPath();
		
		String username = jsonpathresponse.get("username");
		String name = jsonpathresponse.get("name");
		String email = jsonpathresponse.get("email");
		String street = jsonpathresponse.get("phone");
		
		System.out.println(name) ;
		System.out.println(username) ;	
		System.out.println(email) ;	
		System.out.println(street) ;	
		
		
	
	}
}
