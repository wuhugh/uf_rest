package com.ufrest.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Credits to baeldung
 * http://www.baeldung.com/java-http-request
 * Converts a Map to a URL appendable query string
 */
public class ParameterStringBuilder {
    public static String getParamsString(Map<String, String> params)  {
        StringBuilder result = new StringBuilder();

        try {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                result.append("&");
            }
        } catch (UnsupportedEncodingException e) {
            // TODO: Handle exception
        }

        String resultString = result.toString();
        return resultString.length() > 0 ? resultString.substring(0, resultString.length() - 1) : resultString;
    }
}
