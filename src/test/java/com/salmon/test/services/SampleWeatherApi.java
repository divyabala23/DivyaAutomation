package com.salmon.test.services;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.salmon.test.enums.ServiceEndPoints;
import com.salmon.test.framework.helpers.ApiHelper;
import com.salmon.test.framework.helpers.Props;
import org.apache.http.client.utils.URIBuilder;

import java.net.URISyntaxException;

public class SampleWeatherApi extends ApiHelper {


public void getWeatherDetails(String city){
    Response response = null;

    RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

    RequestSpecification httpRequest = RestAssured.given();

    response = httpRequest.get("/city");

//    System.out.println("Response Body is =>  " + response.asString());



}





}
