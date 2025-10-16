package test.rest.ytube;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthorizationDemo {

	@Test
	public void Bearer() {
		
		//url---https://gorest.co.in/public/v2/users
		//create request specification
		RequestSpecification requestSpec = RestAssured.given();
		
		requestSpec.baseUri("https://gorest.co.in");
		requestSpec.basePath("/public/v2/users");
		
		JSONObject payload = new JSONObject();
		payload.put("name", "Rohit");
		payload.put("gender", "Male");
		payload.put("email", "qatester@gmail.com");
		payload.put("status", "Active");
		
		String AuthToken = "Bearer 1ba3df298d4c8cc0170b45cce106f542f2d33c6d083597316cf44d413502de63";
		
		requestSpec.headers("Authorization", AuthToken).contentType(ContentType.JSON).body(payload.toString());
		
		//perform post request
		Response response = requestSpec.post();
		
		Assert.assertEquals(response.statusCode(), 201, "Check for status code");
		
		System.out.println("Response status: " + response.statusLine());
		System.out.println("Response body: " + response.body().asString());
		
		
		
	}
	
	
}
