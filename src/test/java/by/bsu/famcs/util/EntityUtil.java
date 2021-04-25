package by.bsu.famcs.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.mock.web.MockHttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class EntityUtil {

    public static <T> T getTestEntity(String fileName, Class<T> clazz) throws IOException {
        return (T) JsonUtil.getTestEntity(fileName, clazz);
    }

    public static <T> T getDto(MockHttpServletResponse response, Class<?> clazz) throws UnsupportedEncodingException, JsonProcessingException {
        return (T) JsonUtil.toDto(response.getContentAsString(), clazz);
    }
}
