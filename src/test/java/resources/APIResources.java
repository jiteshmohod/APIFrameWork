package resources;

public enum APIResources {
	
	
	AppPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");
	
	private  String resource;
	
	
	

	APIResources(String string) {
		// TODO Auto-generated constructor stub
		this.resource=string;
	}

	
	
	public  String getResource() {
		return resource;
		
	}

}
