package apiframework;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo3_JSONObject {

	@Test
	public void user() {

	//Specify the base URL to RESTful web service
	RestAssured.baseURI = "https://www.pmc.gov.in/en/pmc-hospital";
	
	//Get the RequestSpecification of the request that want to send to the server
	RequestSpecification request = RestAssured.given();
	
	//add a header starting the Request body is JSON
	request.header("Content-Type","application/json");
	
	//create an object for JSONobject class
	JSONObject requestParams = new JSONObject();
	
	//we can add key value pairs using put method
	requestParams.put("patientid","1806");
	requestParams.put("patientName","Nikhil");
	requestParams.put("age","26");
	requestParams.put("temp","98.38");
	requestParams.put("diagnosis","Fever");
	
	//Add string foem of JSON to the body of the request
	request.body(requestParams.toString());
	
	//post the request and check the response
	Response response = request.post("/AdmitPatient");
	
	int statusCode = response.getStatusCode();
	System.out.println(statusCode);
	Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Incorrect status code returned");
	
  }
}
