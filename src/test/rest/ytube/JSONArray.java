package test.rest.ytube;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONArray {

	@Test
	public void createUserUsingJSONArray() {
		
		JSONObject user1 = new JSONObject();
		user1.put("firstName", "Sagar");
		user1.put("lastName", "Mundale");
		user1.put("age", 28);
		user1.put("salary", 10000.56);
		
		JSONObject user2 = new JSONObject();
		user2.put("firstName", "Ajay");
		user2.put("lastName", "Nandi");
		user2.put("age", 28);
		user2.put("salary", 10000.56);

		JSONObject user3 = new JSONObject();
		user3.put("firstName", "Vijay");
		user3.put("lastName", "Gavali");
		user3.put("age", 28);
		user3.put("salary", 10000.56);
		
//		//add JSON object to JSON Array
//		JSONArray userPayLoad = new JSONArray();
//		userPayLoad.add(user1);
//		userPayLoad.add(user2);
//		userPayLoad.add(user3);
		
		//create Request Specification
		RequestSpecification reqSpec = RestAssured.given();
				
		//specify URL
		reqSpec.baseUri("https://reqres.in/api/users");
		reqSpec.contentType(ContentType.JSON);
		
//		reqSpec.body(userPayLoad);
		Response response = reqSpec.post();
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 400, "Check for status code");
		
	}
}
