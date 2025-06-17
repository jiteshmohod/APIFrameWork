package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification req;
	
	public RequestSpecification requestSpecification() throws IOException {
		if(req==null)	{
		PrintStream log = new PrintStream(new FileOutputStream("logging.text"));
		return  req = new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri(getGlobalValue("baseURL"))
				.addQueryParam("key","qaclick123").addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
		}
		return req;
	}
	
	public static String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\EclipseWorkSpace\\src\\test\\java\\resources\\Global.properties");
		prop.load(fis);
		return prop.getProperty(key); 
		
		
	}
	public String getJsonPath(Response response, String key) {
		
		JsonPath js = new JsonPath(response.asString());
		return js.get(key).toString();
		
	}
	

}
