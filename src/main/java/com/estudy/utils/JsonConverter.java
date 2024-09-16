package com.estudy.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

@UtilityClass
@Log
public final class JsonConverter {
    public static final ObjectMapper jsonMapper = new ObjectMapper();


    static {
        jsonMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        jsonMapper.disable(JsonParser.Feature.STRICT_DUPLICATE_DETECTION);
    }


    public String writeValueAsString(Object object) {
        try {
            return jsonMapper.writeValueAsString(object);
        } catch (Exception exception) {
            log.log(Level.WARNING, "MapperService > writeValueAsString got exception", exception);
        }
        return "";
    }

    public <T> T readValue(String object, Class<T> clazz) {
        try {
            return jsonMapper.readValue(object, clazz);
        } catch (Exception exception) {
            log.log(Level.WARNING, "MapperService > readValue got exception", exception);
        }
        return null;
    }

    public <T> List<T> readValueAsArray(String object, Class<T> clazz) {
        try {
            return jsonMapper.readValue(object, jsonMapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (Exception exception) {
            log.log(Level.WARNING, "MapperService > readValue got exception", exception);
        }
        return Collections.emptyList();
    }

}
