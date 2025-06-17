package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.DeletePlace;

public class TestDataBuild {
	
	public  AddPlace addPlacePayload(String name, String language, String address) {
		
		pojo.AddPlace  p = new pojo.AddPlace();
		pojo.Location l = new pojo.Location();
		List<String> list = new ArrayList<>();
		list.add("Car");
		list.add("Banana");
		l.setLat(30.4585245);
		l.setLng(-36.25487);
		p.setAccuracy("50");
		p.setAddress(address);
		p.setLanguage(language);
		p.setLocation(l);
		p.setTypes(list);
		p.setPhone_number(9922545);
		p.setName(name);
		p.setWebsite("www.manewada1.com");
		return p;
	}

	public DeletePlace deletePlacePaylaod(String place_id) {
		DeletePlace d = new DeletePlace();
		d.setPlace_id(place_id);
		return d;
		
	}
}
