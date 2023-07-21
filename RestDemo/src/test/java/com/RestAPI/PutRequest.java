package com.RestAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class PutRequest {

	@Test
	public void updateUser() {
				
		//send the request body using json object
		JSONObject data=new JSONObject();
		data.put("name", "Nila");
		data.put("job", "Analyst");
		
		String dataString = data.toJSONString();
		
		given()
		  .relaxedHTTPSValidation()
		  .body(dataString)
		  .header("Content-Type", "application/json")//to set the content type in header
		.when()
		  .put("https://reqres.in/api/users/2")
		.then()
		  .statusCode(200)
		  .header("Content-Type", equalTo("application/json; charset=utf-8"))//validating header data
		  .log().all();
	}
}
