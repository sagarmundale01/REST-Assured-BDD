package apiframework;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Demo2_Assertions {

	@Test
	public void user() {
		
		Response response;
		response = RestAssured.get("https://www.croma.com/search");
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Incorrect Status code is returned");
	    
		String ContentType = response.getContentType();
	    System.out.println(ContentType);
		Assert.assertEquals(ContentType /*actual value*/ , "text/html; charset=utf-8" /*expected value*/ );
		
		//validating text from response
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains("chroma") /*expected value*/, true /*actual vlaue*/, "Response body does not contain chroma");
			
	}		
}
