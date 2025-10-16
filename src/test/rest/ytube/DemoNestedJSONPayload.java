package test.rest.ytube;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DemoNestedJSONPayload {

	@Test
	public void createUser() throws JsonProcessingException
	{
		EmployeePOJOClass emp1 = new EmployeePOJOClass();
		
		emp1.setFirstname("Suresh");
        emp1.setLastname("Mishra");
	    emp1.setGender("Male");
	    emp1.setAge(34);
	    emp1.setSalary(10000.45);
	    
	    EmployeeAddress emp1Address = new EmployeeAddress();
	    emp1Address.setStreet("Park Avenue");
        emp1Address.setCity("Vijaywada");
        emp1Address.setState("AP");
        emp1Address.setPincode(530012);
	    
        emp1.setAddress(emp1Address);
	    
        ObjectMapper objMapper = new ObjectMapper();
        String jsonpayload = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
        
        RequestSpecification reqSpec = RestAssured.given();
        
        reqSpec.baseUri("http://httpbin.org/post");
        reqSpec.contentType(ContentType.JSON);
        reqSpec.body(jsonpayload);
        
        Response response = reqSpec.post();
        response.prettyPrint();
        
        System.out.println("JsonPayLoad: " + jsonpayload);
     
        
        
        
	}
	
	
}
