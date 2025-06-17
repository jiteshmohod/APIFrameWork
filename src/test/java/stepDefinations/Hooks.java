package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		StepDefination steps = new StepDefination();
		
		if(StepDefination.place_id==null) {
		steps.add_place_payload_with("Jitesh", "French","Pune");
		steps.user_calls_api_with_http_request("AppPlaceAPI", "post");
		steps.verify_place_id_matches_with("GetPlaceAPI", "Jitesh");
		}
	}

}
