package test.rest.ytube;

import static io.restassured.RestAssured.given;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteExample {

	@Test
	public void testPut() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Sagar");
		request.put("job", "Teacher");
		
//		Map<String, Object> map = new HashMap<String,Object>();
//		map.put("name", "Sagar");
//		map.put("job", "Teacher");
//		System.out.println(map);
//		JSONObject request = new JSONObject(map);
		
		System.out.println(request.toString());
		String baseURI = "https://reqres.in/api";
		
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toString()).
		
		when().
		put("/users/2").
		
		then().
		statusCode(200).
		log().all();
		
	
	}
	
	
	
}
