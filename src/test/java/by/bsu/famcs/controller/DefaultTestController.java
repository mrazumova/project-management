package by.bsu.famcs.controller;

import by.bsu.famcs.util.EntityUtil;
import by.bsu.famcs.util.JsonUtil;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public interface DefaultTestController<T> {

    default T createEntityTest() throws Exception {
        MockHttpServletResponse response = getMockMvc()
                .perform(post(getEntityEndpoint())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtil.toJson(getEntity())))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();

        T created = EntityUtil.getDto(response, getEntityClass());

        return created;
    }

    default T getEntityByIdTest(String id) throws Exception {
        MvcResult mvcResult = getMockMvc()
                .perform(get(getEntityEndpoint() + "/" + getEntityIdParam(), id))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        T resultDto = EntityUtil.getDto(mvcResult.getResponse(), getEntityClass());

        return resultDto;
    }

    default T updateEntityTest(String id) throws Exception {
        MvcResult result = getMockMvc()
                .perform(put(getEntityEndpoint() + "/" + getEntityIdParam(), id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtil.toJson(getEntity())))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        T updated = EntityUtil.getDto(result.getResponse(), getEntityClass());

        return updated;
    }

    default void removeEntityByIdTest(String id) throws Exception {
        getMockMvc()
                .perform(delete(getEntityEndpoint() + "/" + getEntityIdParam(), id))
                .andDo(print())
                .andExpect(status().isOk());
    }

    default void checkIsDeletedEntityTest(String id) throws Exception {
        getMockMvc()
                .perform(get(getEntityEndpoint() + "/" + getEntityIdParam(), id))
                .andDo(print())
                .andExpect(status().is(404));
    }

    MockMvc getMockMvc();

    String getEntityEndpoint();

    String getEntityIdParam();

    T getEntity();

    Class<T> getEntityClass();
}

