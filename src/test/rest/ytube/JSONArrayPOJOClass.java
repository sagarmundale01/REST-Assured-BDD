package test.rest.ytube;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONArrayPOJOClass {

	@Test
	public void createEmplyeesJSONArray() throws JsonProcessingException{
		
		
		//serialization 
		
		//create first employee Object
		Employee emp1 = new Employee();

		emp1.setFirstName("Suresh");
		emp1.setLastName("Mehra");
		emp1.setGender("Male");
		emp1.setAge(34);
		emp1.setSalary(10000.45);
		
		
		//create second employee object
		Employee emp2 = new Employee();
		
		emp2.setFirstName("Ram");
		emp2.setLastName("Singh");
		emp2.setGender("Male");
		emp2.setAge(30);
		emp2.setSalary(34000.45);
		
		
		//create third employe object
		Employee emp3 = new Employee();
		
		emp3.setFirstName("Divya");
		emp3.setLastName("Guru");
		emp3.setGender("Female");
		emp3.setAge(34);
		emp3.setSalary(35000.45);
		
		
		//create List of Employee
		List<Employee> listOfEmp = new ArrayList<Employee>();
		
		listOfEmp.add(emp1);
		listOfEmp.add(emp2);
		listOfEmp.add(emp3);
		
		//Convert employee class object to JSON Array Payload as String
		ObjectMapper objMapper = new ObjectMapper();
		
		String jsonArrayPayload = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(listOfEmp);
		
		System.out.println("Employee class objects to json Array payload");
		System.out.println(jsonArrayPayload);
		
		
		//Create Request Specification
		RequestSpecification reqSpec = RestAssured.given();
		
		//Specify URL
		reqSpec.baseUri("https://reqres.in/api/users");
	    reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jsonArrayPayload);
		
		//performPOST request
		Response response = reqSpec.post();
		System.out.println("------------Response Body--------");
		response.prettyPrint();
		
		//verify the status code
		Assert.assertEquals(response.statusCode(),401);
		
		
	}
	
	
}
