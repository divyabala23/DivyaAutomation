package com.salmon.test.services;

import com.salmon.test.framework.helpers.Props;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URISyntaxException;

public class UkLocationApi {
    public static HttpResponse getUKLocationByCounty(String county) throws IOException, URISyntaxException {

        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder(Props.getProp("api.url"));
        uriBuilder .setParameter("county",county);
        HttpGet request = new HttpGet(uriBuilder.build());

        HttpResponse response = null;

        try {
            response = client.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;

    }

}



