package by.bsu.famcs.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.FileReader;
import java.io.IOException;

public class JsonUtil {

    private static final String PATH = "src/test/resources/entity/";

    private static final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    public static Object getTestEntity(String path, Class c) throws IOException {
        return mapper.readValue(new FileReader(PATH + path), c);
    }

    public static String toJson(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    public static Object toDto(String json, Class classType) throws JsonProcessingException {
        return mapper.readValue(json, classType);
    }
}
