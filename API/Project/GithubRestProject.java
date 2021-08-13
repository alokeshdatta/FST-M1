package com.ibm.rest_assured.restassured_projectActivity;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GithubRestProject {
	
	String SSHKey;
	//String token;
	String baseURI = "https://api.github.com";
	RequestSpecification requestSpec;
	int userId;
	
	@BeforeClass
	public void setUp() {
		  
		  requestSpec = new RequestSpecBuilder().setContentType(ContentType.JSON)
				  		.addHeader("Authorization","token ******")
				        .setBaseUri(baseURI)
				        .build();
	
	}
  
  @Test(priority=1)
  public void postRequest() {
	  
	  String requestBody = "{\"title\": \"TestAPIKey\", \"key\": \"ssh-rsa *****\", \"read_only\": \"true\"}";
      Response response = given().spec(requestSpec) 
              .body(requestBody) 
              .when().post("/user/keys").then().extract().response();
      
      userId = response.path("id");
      System.out.println(userId);
      String body = response.asPrettyString();
//      String body = response.getBody().asPrettyString();
      System.out.println(body);
      response.then().statusCode(201);
      
      System.out.println("1st Test is passed");
          
	  
  }
  
  @Test(priority=2)
  public void getRequest() {
	  
	  Response response = given().spec(requestSpec)
              .when().get("/user/keys").then().extract().response();
	  String body = response.asPrettyString();
	  System.out.println(body);
      response.then().statusCode(200);
	  
	  System.out.println("2nd Test is passed");
	  //Reporter.log(body);
  }
  
  @Test(priority=3)
  public void deleteRequest() throws InterruptedException {
	  
	  Thread.sleep(4000);
	  Response response = given().spec(requestSpec) 
              .pathParam("keyId", userId) 
              .when().delete("/user/keys/{keyId}");

    //Reporter.log(body);
      response.then().statusCode(204);
	  System.out.println("3rd Test is passed");
	  
  }
  
  
}
