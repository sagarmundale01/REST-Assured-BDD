package apiframework;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class Learning {

	@Test
	public void f() {
		JSONObject parameters = new JSONObject();
		parameters.put("name", "Jonh");
		parameters.put("Designation", "Test Engineer");
		parameters.put("id", 100);
		
		//create new JSON Object to store contact details
		JSONObject details = new JSONObject();
		details.put("offical Number", 123456789);
		details.put("Personal Number", 234347850);
		details.put("Land line", 234323);
		details.put("Email id", "abc@gmail.com");
		
		//make details as value to "Contact" Key
		parameters.put("Contact", details);
		
		//print the JSON object as String in the console
		System.out.println(parameters.toString());
		
		
	}
}
