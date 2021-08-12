package activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity1 {
  
	static String ROOT_URI = "https://petstore.swagger.io/v2/pet/";

	@Test(priority=1)
	public void addPet() {
	   
		String reqBody = "{ \"id\": 79235, \"name\": \"Luffy\", \"status\": \"alive\" }";
		  
	    Response response = 
	        given().contentType(ContentType.JSON)
	        .body(reqBody).when().post(ROOT_URI); 
	    String body = response.getBody().asPrettyString();
	    System.out.println("PostRequet is: "+body);
	}
	@Test(priority=2)
	public void getPet() {
	    Response response = 
	        given().contentType(ContentType.JSON) 
	        .when().pathParam("id", "79235").get(ROOT_URI + "{id}"); 

	    // Print response
	    System.out.println("GetRequet is: "+response.asPrettyString());
	    // Assertions
	    response.then().body("status", equalTo("alive")).body("name", equalTo("Luffy")).body("id", equalTo(79235));
	   	}
  
  @Test(priority=3)
  public void deletePet() {
	  Response response = 
		        given().contentType(ContentType.JSON)
		        .when().pathParam("id", "79235").delete(ROOT_URI + "{id}");
	  System.out.println("DeleteRequet is: "+response.asPrettyString());
	  response.then().body("code", equalTo(200)).body("message", equalTo("79235"));
	  
	  
  }

}
