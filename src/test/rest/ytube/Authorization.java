package test.rest.ytube;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authorization {

	@Test
	public void BasicAuth()	{
		
		RequestSpecification requestSpec = RestAssured.given();
		//specify URL
		requestSpec.baseUri("http://postman-echo.com");
		requestSpec.basePath("/basic-auth");
		
		//PerformGet request
		Response response = requestSpec.auth().preemptive().basic("postman", "password").get();
		
		System.out.println("Response status: " + response.statusLine());
		System.out.println("Response body: " +   response.body().asString());
		
		
	}
	
		@Test
		public void DigestAuth()	{
			
			RequestSpecification requestSpec = RestAssured.given();
			//specify URL
			requestSpec.baseUri("https://httpbin.org");
			requestSpec.basePath("/digest-auth/undefined/sagar/sagar");
			
			//Perform Get request
			Response response = requestSpec.auth().digest("sagar", "sagar").get();
			
			Assert.assertEquals(response.statusCode(), 200);
			
			//print status line
			System.out.println("Response status: " + response.statusLine());
			System.out.println("Response body: " +   response.body().asString());
			
			
		}
}
