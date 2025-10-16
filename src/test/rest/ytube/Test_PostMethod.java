package test.rest.ytube;

import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class Test_PostMethod {

	@Test
	public void test03()
	{
		JSONObject jsonData = new JSONObject();
		
		jsonData.put("name", "Sagar");
		jsonData.put("job", "QA");
		
		baseURI= "https://reqres.in/api/users";
		
		given().header("Content-type", "application/json").
		contentType(ContentType.JSON).
		body(jsonData.toString()).
		
		when().post().
		then().statusCode(201).
		log().all();
		
	}
	
	@Test
	public void test04()
	{
		JSONObject jsonData = new JSONObject();
		
		jsonData.put("name", "Alex");
		jsonData.put("job", "Tester");
		
		baseURI= "https://reqres.in/api/users/52";
		
		given().header("Content-type", "application/json").
		contentType(ContentType.JSON).
		body(jsonData.toString()).
		
		when().post().
		then().statusCode(201).
		log().all();
		
	}
	
	
}
