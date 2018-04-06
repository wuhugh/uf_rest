package com.ufrest.resources;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class UFResponse {
    private Map<String, Object> jsonData = new HashMap<>();

    public Object get(String name) {
        return jsonData.get(name);
    }

    @JsonAnyGetter
    public Map<String,Object> any() {
        return jsonData;
    }

    @JsonAnySetter
    public void set(String name, Object value) {
        jsonData.put(name, value);
    }
}
