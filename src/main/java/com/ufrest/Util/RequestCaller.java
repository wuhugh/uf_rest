package com.ufrest.Util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ufrest.CourseResource.CoursesWrapper;
import com.ufrest.ResponseObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class RequestCaller {
    // This may or may not be good practice
    private static URL url;
    private static HttpURLConnection connection = null;
    private static StringBuffer data = new StringBuffer();
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static int status = 0;

    public static Object callSOC(String scheduleOfCoursesURL, Map<String, String> requestParameters) {
        CoursesWrapper[] coursesWrapper;

        try {
            url = new URL(scheduleOfCoursesURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            status = connection.getResponseCode();

            coursesWrapper = objectMapper.readValue(url, CoursesWrapper[].class);
        } catch (Exception e) {
            return ErrorHandler.getExceptionResponse(e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return new ResponseObject(true, status, coursesWrapper[0], "Data successfully retrieved from " + scheduleOfCoursesURL);
    }

}
