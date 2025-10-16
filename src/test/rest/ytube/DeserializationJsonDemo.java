package test.rest.ytube;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class DeserializationJsonDemo {

	@Test
	public void createUser()
	{

		//https://reqres.in/api/users
		//create Request Specification
		
		RequestSpecification requestSpec = RestAssured.given();
		
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users");
		
		//create request body
		JSONObject jsonData = new JSONObject();
		
		jsonData.put("name", "Sagar");
		jsonData.put("job", "QA");
		
		//performpost request
		Response response = requestSpec.
		contentType(ContentType.JSON).
		body(jsonData.toString()).
		post();
		
	
		ResponseBody responseBody = response.getBody();
		
		
		
	}	
}
