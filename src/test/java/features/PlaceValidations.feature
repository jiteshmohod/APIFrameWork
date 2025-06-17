Feature: Validating place API's
@AddPlace
Scenario Outline: Verify if place is being added using addPlace Api
Given add place payload with "<name>"  "<language>"  "<address>"
When user calls "AppPlaceAPI" Api with "post" http request
Then API call is sccucess with status code 200
And "status" in response is "OK" 
And "scope" in response is "APP"
And verify "GetPlaceAPI" placeId matches with "<name>"

Examples: 
	|name|language|address|
	|Punjab|Punjabi|Bhatinda|
	#|Michel|English|Walls|
	
	
	@DeletePlace
	Scenario: Verify delete call
	Given deleteAPI payload
	When user calls "DeletePlaceAPI" Api with "DELETE" http request
	Then API call is sccucess with status code 200
	And "status" in response is "OK"
	