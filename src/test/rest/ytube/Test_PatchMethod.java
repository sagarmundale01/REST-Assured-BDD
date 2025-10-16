package test.rest.ytube;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_PatchMethod {

	
	@Test
	public void test05()
	{
		JSONObject jsonData = new JSONObject();
		
		jsonData.put("name", "Alex");
		jsonData.put("job", "Tester");
		
		baseURI= "https://reqres.in/api/users/52";
		
		given().header("Content-type", "application/json").
		contentType(ContentType.JSON).
		body(jsonData.toString()).
		
		when().patch().
		then().statusCode(401).
		log().all();
		
	}
	
}
