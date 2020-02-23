package learningAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_RegisterCustomerAPI {
	 
	 @Test
	 void RegistrationSuccessful()
	 {
	  
	  //Specify base URI
	  RestAssured.baseURI="http://restapi.demoqa.com/customer";
	  
	  //Request object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	   
	  //Request pay load sending along with post request
	  JSONObject requestParams=new JSONObject();
	  
	  requestParams.put("FirstName","JohnXYZAB");
	  requestParams.put("LastName","XYZJohnAB");
	  requestParams.put("UserName","JohnXYZAB");
	  requestParams.put("Password","JohnXYZxyxab");
	  requestParams.put("Email","JohnXYZAB@gmail.com");
	  
	  httpRequest.header("Content-Type","application/json");
	  
	  httpRequest.body(requestParams.toJSONString()); // attach above data to the request
	  
	  //Response object
	  Response response=httpRequest.request(Method.POST,"/register");
	    
	  
	  //print response in console window
	  
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is:" +responseBody);
	  
	  //status code validation
	  int statusCode=response.getStatusCode();
	  System.out.println("Status code is: "+statusCode);
	  Assert.assertEquals(statusCode, 201);
	  
	  //success code validation
	  String successCode=response.jsonPath().get("SuccessCode");
	  Assert.assertEquals(successCode, "OPERATION_SUCCESS");
	  
	 }
	 

	

}
