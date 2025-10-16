package test.rest.ytube;

import org.junit.Assert;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateQueryParameter {

	@Test
	public void filterData()
	{
		//Get Request specifcation for the givem request
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify url
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users");
		requestSpec.queryParam("page", 2).queryParam("id", 10);
		
		//perform get request
		Response response = requestSpec.get();
	
		String responseBodyString = response.getBody().asString();
        
		System.out.println("Response body: "+ responseBodyString);
		
		//get json path view of response body
		JsonPath JsonPathView = response.jsonPath();
		
		//get first name
		String firstName = JsonPathView.get("data.first_name");
		
		Assert.assertEquals("firstName", "Byron", "Verify firstname");
		
	
	
	
	}
	
	
}
