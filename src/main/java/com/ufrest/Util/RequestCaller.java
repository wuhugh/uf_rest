package com.ufrest.Util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ufrest.resources.UFResponse;
import com.ufrest.ResponseObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class RequestCaller {
    // This may or may not be good practice
    private static URL url;
    private static HttpURLConnection connection = null;
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static int status = 0;

    public static Object callSOC(String scheduleOfCoursesURL, Map<String, String> requestParameters) {
        UFResponse[] ufResponse;

        try {
            url = new URL(scheduleOfCoursesURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            status = connection.getResponseCode();

            ufResponse = objectMapper.readValue(url, UFResponse[].class);
        } catch (IOException e) {
            return ErrorHandler.getExceptionResponse(e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return new ResponseObject(true, status, ufResponse, "Data successfully retrieved from " + scheduleOfCoursesURL);
    }

}
