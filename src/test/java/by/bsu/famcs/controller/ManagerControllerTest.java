package by.bsu.famcs.controller;

import by.bsu.famcs.dto.ManagerDto;
import by.bsu.famcs.util.EntityUtil;
import org.junit.ClassRule;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;

import java.io.IOException;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ManagerControllerTest implements DefaultTestController<ManagerDto> {

    private static final String MANAGER_ENTITY_FILE = "manager.json";

    @ClassRule
    private static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.0");

    private static ManagerDto manager;

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    static void setUp() throws IOException {
        mySQLContainer.start();
        System.setProperty("spring.datasource.url", mySQLContainer.getJdbcUrl());
        System.setProperty("spring.datasource.username", mySQLContainer.getUsername());
        System.setProperty("spring.datasource.password", mySQLContainer.getPassword());
        manager = EntityUtil.getTestEntity(MANAGER_ENTITY_FILE, ManagerDto.class);
    }

    @Test
    @Order(1)
    void create() throws Exception {
        ManagerDto created = createEntityTest();
        manager = created;
    }

    @Test
    @Order(2)
    void getById() throws Exception {
        getEntityByIdTest(manager.getId());
    }

    @Test
    @Order(3)
    void update() throws Exception {
        ManagerDto updated = updateEntityTest(manager.getId());
        manager = updated;
    }

    @Test
    @Order(4)
    void deleteById() throws Exception {
        removeEntityByIdTest(manager.getId());
    }

    @Test
    @Order(5)
    void checkIsDeleted() throws Exception {
        checkIsDeletedEntityTest(manager.getId());
    }

    @Override
    public MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    public String getEntityEndpoint() {
        return "/managers";
    }

    @Override
    public String getEntityIdParam() {
        return "{managerId}";
    }

    @Override
    public ManagerDto getEntity() {
        return manager;
    }

    @Override
    public Class<ManagerDto> getEntityClass() {
        return ManagerDto.class;
    }
}