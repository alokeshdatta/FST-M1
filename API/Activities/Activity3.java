package activities;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Activity3 {
  
	String baseURI = "https://petstore.swagger.io/v2/pet";
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	
	@DataProvider
    public Object[][] petInfoProvider() {
        Object[][] data = new Object[][] { 
            { 77084, "Luffy", "alive" }, 
            { 77085, "Jolly", "alive" }
        };
        return data;
    }
	
	@BeforeTest
	public void setUp() {
	  
	  requestSpec = new RequestSpecBuilder().setContentType(ContentType.JSON)
			        .setBaseUri(baseURI)
			        .build();
	  
	  responseSpec = new ResponseSpecBuilder().expectContentType("application/json")
	  			     .expectStatusCode(200)
	  			     .expectBody("status", equalTo("alive"))
	  			     .build();
  }
	
	
	@Test(priority=1)
	public void addPetsTest() {
		String reqBody = "{\"id\": 77084, \"name\": \"Luffy\", \"status\": \"alive\"}";
        Response response = given().spec(requestSpec) 
                .body(reqBody) 
                .when().post(); 
        
        reqBody = "{\"id\": 77085, \"name\": \"Jolly\", \"status\": \"alive\"}";
        response = given().spec(requestSpec)
        		.body(reqBody)
                .when().post();
 
        response.then().spec(responseSpec);
  }
  
	@Test(dataProvider = "petInfoProvider", priority=2)
	public void getPetsTest(int id, String name, String status) {
      Response response = given().spec(requestSpec) 
              .pathParam("petId", id) 
              .when().get("/{petId}"); 

      
      System.out.println(response.asPrettyString());
      response.then()
      .spec(responseSpec)
      .body("name", equalTo(name)); 
  }

  
//Test case using a DataProvider
  @Test(dataProvider = "petInfoProvider", priority=3)
  public void deletePetsTest(int id, String name, String status) {
      Response response = given().spec(requestSpec) 
              .pathParam("petId", id) 
              .when().delete("/{petId}");

      response.then().body("code", equalTo(200));
  }
}
