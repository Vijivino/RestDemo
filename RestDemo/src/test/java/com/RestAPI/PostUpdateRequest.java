package com.RestAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class PostUpdateRequest {
	int id;
	@Test(priority=1)
	public void CreateUser() {
		
		//since it is a post req to create user, we need to send the reqbody using JsonObject
		JSONObject data=new JSONObject();
		data.put("name", "Linda");
		data.put("job", "Tester");
		
		//convert the json obj to jsonstring
		String datastring = data.toJSONString();
		
		//No need to have base URI seperately,we can pass the entire url in the request itself.
		id=given()
		  .relaxedHTTPSValidation()
		  .body(datastring)
		.when()
		   .post("https://reqres.in/api/users")
		   .jsonPath().getInt("id");
		System.out.println(id);
		   
//		.then()
//		   .statusCode(201)
//		.log().all();
		
	}
	
	@Test(priority=2,dependsOnMethods= {"CreateUser"})
	public void UpdateUser() {
		
		//since it is a post req to create user, we need to send the reqbody using JsonObject
		JSONObject data=new JSONObject();
		data.put("name", "mirnalini");
		data.put("job", "Tester");
		
		//convert the json obj to jsonstring
		String datastring = data.toJSONString();
		
		//No need to have base URI seperately,we can pass the entire url in the request itself.
		given()
		  .relaxedHTTPSValidation()
		  .body(datastring)
		.when()
		   .put("https://reqres.in/api/users/"+id)
	   	.then()
		   .statusCode(200)
		.log().all();
		
	}
	

}
