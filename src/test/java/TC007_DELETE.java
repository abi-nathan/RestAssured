import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC007_DELETE {

	
	@Test
	public void deleterequest()
	{
		RestAssured.baseURI = "https://reqres.in/api/users/2";
		RequestSpecification httprequest = RestAssured.given();
		
		httprequest.header("Content-Type", "application/jason");
		
		Response response = httprequest.delete("users/2");
		
		int statuscode = response.getStatusCode();
		System.out.println("The response body is "+response.getBody().asPrettyString());

		System.out.println("The status code received = "+statuscode);
		
		Assert.assertEquals(statuscode, 204);
		
		//status 204 means deleted but it no content for any validation like below
		
		/*String jsonstring = response.asPrettyString();
		System.out.println(jsonstring);
		Assert.assertEquals(jsonstring.contains("Deleted the records successfully"),true);*/
		
		
	}
	
}
