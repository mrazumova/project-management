package by.bsu.famcs.controller;

import by.bsu.famcs.dto.DeveloperDto;
import by.bsu.famcs.util.EntityUtil;
import org.junit.ClassRule;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;

import java.io.IOException;

import static by.bsu.famcs.common.TestConstant.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DeveloperControllerTest implements DefaultTestController<DeveloperDto> {

    private static final String DEVELOPER_ENTITY_FILE = "developer.json";

    @ClassRule
    private static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.0");

    private static DeveloperDto developer;

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    static void setUp() throws IOException {
        mySQLContainer.start();
        System.setProperty("spring.datasource.url", mySQLContainer.getJdbcUrl());
        System.setProperty("spring.datasource.username", mySQLContainer.getUsername());
        System.setProperty("spring.datasource.password", mySQLContainer.getPassword());
        developer = EntityUtil.getTestEntity(DEVELOPER_ENTITY_FILE, DeveloperDto.class);
    }

    @Test
    @Order(1)
    @WithMockUser(value = DEFAULT_USER_ID, roles = EDIT_DATA)
    void create() throws Exception {
        DeveloperDto created = createEntityTest();
        developer = created;
    }

    @Test
    @Order(2)
    @WithMockUser(value = DEFAULT_USER_ID, roles = READ_DATA)
    void getById() throws Exception {
        getEntityByIdTest(developer.getId());
    }

    @Test
    @Order(3)
    @WithMockUser(value = DEFAULT_USER_ID, roles = EDIT_DATA)
    void update() throws Exception {
        DeveloperDto updated = updateEntityTest(developer.getId());
        developer = updated;
    }

    @Test
    @Order(4)
    @WithMockUser(value = DEFAULT_USER_ID, roles = EDIT_DATA)
    void deleteById() throws Exception {
        removeEntityByIdTest(developer.getId());
    }

    @Test
    @Order(5)
    @WithMockUser(value = DEFAULT_USER_ID, roles = READ_DATA)
    void checkIsDeleted() throws Exception {
        checkIsDeletedEntityTest(developer.getId());
    }

    @Override
    public MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    public String getEntityEndpoint() {
        return "/developers";
    }

    @Override
    public String getEntityIdParam() {
        return "{developerId}";
    }

    @Override
    public DeveloperDto getEntity() {
        return developer;
    }

    @Override
    public Class<DeveloperDto> getEntityClass() {
        return DeveloperDto.class;
    }

}
