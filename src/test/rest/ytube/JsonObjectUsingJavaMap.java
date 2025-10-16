package test.rest.ytube;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JsonObjectUsingJavaMap {

	@Test(enabled = false)
	public void createAuthToken() {
		
		//Create JSON Object using Java Map
		/*
		 * {
    "username" : "admin",
    "password" : "password123"
         }
		 */
		
		Map<String, String> authToken = new HashMap<String, String>();
		
		authToken.put("username", "admin");
		authToken.put("password", "password123");
		
		Response response = RestAssured.given().
		baseUri("https://restful-booker.herokuapp.com/auth").
		contentType(ContentType.JSON).
		body(authToken).
		post();
		
		response.prettyPrint();
				
		Assert.assertEquals(response.statusCode(),201, "Check for status code");
		
	}	
	
	@Test(enabled = true)
	public void createUser()
	{
		
		/*
		 {
    "firstName": "Sagar",
    "lastName": "Mundale",
    "age": 28,
    "salary": 10000.56,
    "IsMarried": true,
    "Hobbies": [
        "Music",
        "Computer",
        "Games"
    ],
    "TechSkill": {
        "Programming language": "Java",
        "WebAutomation": "Selenium",
        "API Testing": "Rest Assured"
    }
}
*/
		HashMap<String,Object> userData = new HashMap<String, Object>();
		userData.put("firstName", "Sagar");
		userData.put("lastName", "Mundale");
		userData.put("age", 28);
		userData.put("salary", 10000.56);
		userData.put("IsMarried", true);
		
		
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("Music");
		hobbies.add("Computer");
		hobbies.add("Game");
		
		userData.put("Hobbies", hobbies);
		
		HashMap<String, String> TechSkill = new HashMap<String, String>();
		TechSkill.put("Programming language", "Java");
		TechSkill.put("WebAutomation", "Selenium");
		TechSkill.put("API Testing", "Rest Assured");
		
		userData.put("TechSkill", TechSkill);
		
		Response response = RestAssured.given().
				baseUri("https://reqres.in/api/users").
				contentType(ContentType.JSON).
				body(userData).
				post();
				
				response.prettyPrint();
		
				//verify status code
				Assert.assertEquals(response.statusCode(),401, "Check for status code");
	}
	
}
