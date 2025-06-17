package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlaceResponse;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils{
	
	ResponseSpecification res;
	RequestSpecification payload;
	Response response;
	AddPlaceResponse addplaceResponse;
	 TestDataBuild data = new TestDataBuild();	
	 static String place_id;

	 @Given("add place payload with {string}  {string}  {string}")
	 public void add_place_payload_with(String name, String language, String address) throws IOException {
	    
		 payload= given().spec(requestSpecification()).body(data.addPlacePayload(name,language,address));
		
		
	}

@When("user calls {string} Api with {string} http request")
public void user_calls_api_with_http_request(String string, String method) {
		
		
		
		APIResources ressourceAPI =APIResources.valueOf(string);
		System.out.println(method);
		if(method.equalsIgnoreCase("POST")) {
		
		// Write code here that turns the phrase above into concrete actions
		response =payload.when().post(ressourceAPI.getResource()).then().log().all().extract().response();
		}
		 if (method.equalsIgnoreCase("GET")) {
			
			// Write code here that turns the phrase above into concrete actions
			response =payload.when().get(ressourceAPI.getResource()).then().log().all().extract().response();
			}
		  
		 if (method.equalsIgnoreCase("DELETE")) {
				
				// Write code here that turns the phrase above into concrete actions
				response =payload.when().delete(ressourceAPI.getResource()).then().log().all().extract().response();
				}
	}
	@Then("API call is sccucess with status code {int}")
	public void api_call_is_sccucess_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(),200);
	   
	}
	@Then("{string} in response is {string}")
	public void in_response_is(String key, String value) {
	    // Write code here that turns the phrase above into concrete actions
		 
				 assertEquals(getJsonPath(response, key), value);
		 
			}
	

	@Then("verify {string} placeId matches with {string}")
	public void verify_place_id_matches_with(String string, String ExpectedName) {
		 place_id =getJsonPath(response,"place_id");
		
		payload =given().spec(req).queryParam("place_id", place_id );
		user_calls_api_with_http_request(string, "get");
		String Actualname =getJsonPath(response,"name");
		assertEquals(ExpectedName,Actualname);
		System.out.println(Actualname);
		System.out.println(ExpectedName);
		
		}
	
	@Given("deleteAPI payload")
	public void delete_api_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(" Place id is    "  +place_id);
		
		 payload =given().spec(req).body(data.deletePlacePaylaod(place_id));
	   //testing for github
		 
		 //another comment okay
	}
}
