package test.rest.ytube;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class ValidateJsonResponseBody {

	//https://reqres.in/api/users?page=2
	
	@Test
	public void UserListResponseBody()
	{
		//get RequestSpecification reference
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify base URI
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("api/users?page=2");
		
		//create get request 
		Response response = requestSpec.get();
		
		//Read response body
		ResponseBody responseBody = response.getBody();
		String responseString = responseBody.asString();
		
		System.out.println("Response body: " + responseString);
		
		//Assert.assertEquals(responseString.contains("Missing API key"), true,"Check for presense of Missing API key");	
		
		//get json path view of response body
		JsonPath JsonPathView = responseBody.jsonPath();
		
		String firstName =JsonPathView.getString("data[0].first_name");
		
		Assert.assertEquals(firstName, "George");
		
		
	}
	
}
