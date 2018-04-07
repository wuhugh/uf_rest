package com.ufrest.dataobject;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the JSON object retrieved from UF's API
 * The JSONAnyGetter/Setter is the lazy way of letting JacksonJSON serialize
 * all of the JSON properties rather than us having to define a new class for each
 */
@SuppressWarnings("unused")
public class UFResponse {
    private Map<String, Object> jsonData = new HashMap<>();

    public Object getValue(String name) {
        return jsonData.get(name);
    }

    @JsonAnyGetter
    public Map<String,Object> getJsonData() {
        return jsonData;
    }

    @JsonAnySetter
    public void setValue(String name, Object value) {
        jsonData.put(name, value);
    }
}
