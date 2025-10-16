package apiframework;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Demo1_Basics {

	@Test
	public void f()
	{
		Response response;
		response = RestAssured.get("https://google.com");
		
		String responseBody = response.getBody().asString();
		System.out.println("Response body is => "+ responseBody);
		System.out.println("Response code is: " + response.getStatusCode());
		
	}
	
	
}
