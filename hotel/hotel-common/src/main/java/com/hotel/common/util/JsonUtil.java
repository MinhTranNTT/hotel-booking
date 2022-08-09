package com.hotel.common.util;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	
	private static final ObjectMapper MAPPER = new ObjectMapper();

    public static String toJSonString(Object o) {
        try {
            StringWriter writer = new StringWriter();
            JsonFactory factory = MAPPER.getFactory();
            JsonGenerator gen = factory.createGenerator(writer);
            MAPPER.writeValue(gen, o);
            gen.close();
            String json = writer.toString();
            writer.close();
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    
    public static String obj2JSon(Object o) {
        try {
            StringWriter writer = new StringWriter();
            JsonFactory factory = MAPPER.getFactory();
            JsonGenerator gen = factory.createGenerator(writer);
            MAPPER.writeValue(gen, o);
            gen.close();
            String json = writer.toString();
            writer.close();
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static <T> T str2bean(String json, Class<T> clazz) {
        try {
            return MAPPER.readValue(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T str2beanIgnoreUnknowProperties(String json, Class<T> clazz) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("rawtypes")
    public static Object str2list(String json, TypeReference valueTypeRef) {
        try {
            return MAPPER.readValue(json, valueTypeRef);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JavaType getCollectionType(Class<?> collectionClass,
                                             Class<?>... elementClasses) {
        return MAPPER.getTypeFactory().constructParametricType(collectionClass,
                elementClasses);
    }

    public static ArrayList<?> str2list(String json, Class<?> clazz) {
        JavaType javaType = getCollectionType(ArrayList.class, clazz);
        ArrayList<?> lst = null;
        try {
            lst = MAPPER.readValue(json, javaType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lst;
    }

    @SuppressWarnings("rawtypes")
    public static Object str2map(String json, TypeReference valueTypeRef) {
        try {
            return MAPPER.readValue(json, valueTypeRef);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
