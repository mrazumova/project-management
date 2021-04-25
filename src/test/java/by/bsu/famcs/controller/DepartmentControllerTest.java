package by.bsu.famcs.controller;

import by.bsu.famcs.dto.DepartmentDto;
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
class DepartmentControllerTest implements DefaultTestController<DepartmentDto> {

    private static final String DEPARTMENT_ENTITY_FILE = "department.json";

    @ClassRule
    private static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.0");

    private static DepartmentDto department;

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    static void setUp() throws IOException {
        mySQLContainer.start();
        System.setProperty("spring.datasource.url", mySQLContainer.getJdbcUrl());
        System.setProperty("spring.datasource.username", mySQLContainer.getUsername());
        System.setProperty("spring.datasource.password", mySQLContainer.getPassword());
        department = EntityUtil.getTestEntity(DEPARTMENT_ENTITY_FILE, DepartmentDto.class);
    }

    @Test
    @Order(1)
    void create() throws Exception {
        DepartmentDto created = createEntityTest();
        department = created;
    }

    @Test
    @Order(2)
    void getById() throws Exception {
        getEntityByIdTest(department.getId());
    }

    @Test
    @Order(3)
    void update() throws Exception {
        DepartmentDto updated = updateEntityTest(department.getId());
        department = updated;
    }

    @Test
    @Order(4)
    void deleteById() throws Exception {
        removeEntityByIdTest(department.getId());
    }

    @Test
    @Order(5)
    void checkIsDeleted() throws Exception {
        checkIsDeletedEntityTest(department.getId());
    }

    @Override
    public MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    public String getEntityEndpoint() {
        return "/departments";
    }

    @Override
    public String getEntityIdParam() {
        return "{departmentId}";
    }

    @Override
    public DepartmentDto getEntity() {
        return department;
    }

    @Override
    public Class<DepartmentDto> getEntityClass() {
        return DepartmentDto.class;
    }
}