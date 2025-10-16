package test.rest.ytube;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAndPostExamples {

	@Test
	public void testGet()
	{
		
		baseURI = "https://reqres.in/api";
		
		given().get("/users?page=2").then().statusCode(200);
		
	}
	
	@Test
	public void testPost() {
		
		Map<String, Object> map = new HashMap<String,Object>();
		
		map.put("name", "Sagar");
		map.put("job", "Teacher");
		
		System.out.println(map);
		
		JSONObject request = new JSONObject(map);
		System.out.println(request.toString());
		
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toString()).
		
		when().
		post("/users").
		
		then().
		statusCode(401).
		log().all();
		
		
		
		
	}
}
