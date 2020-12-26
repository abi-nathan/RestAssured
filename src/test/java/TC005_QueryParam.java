import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC005_QueryParam {

	@Test
	public void queryparam()
	{
		
		RestAssured.baseURI = "https://reqres.in/api/";
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.queryParam("page", "2").get("users");
		String jasonstring = response.asPrettyString();
		
		System.out.println(jasonstring);
		
		System.out.println(response.getStatusCode());
		
		Assert.assertEquals(jasonstring.contains("Michael"), true);
	}
	
	
	
	
}
