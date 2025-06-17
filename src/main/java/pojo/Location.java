package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
		
private double lat;

private double lng;

private double longitude;
private double latitude;
public double getLongitude() {
	return longitude;
}
public void setLongitude(double longitude) {
	this.longitude = longitude;
}
public double getLatitude() {
	return latitude;
}
public void setLatitude(double latitude) {
	this.latitude = latitude;
}
public double getLat() {
	return lat;
}
public void setLat(double lat) {
	this.lat = lat;
}
public double getLng() {
	return lng;
}
public void setLng(double lng) {
	this.lng = lng;
}

}
