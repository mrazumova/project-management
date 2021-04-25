package by.bsu.famcs.controller;

import by.bsu.famcs.dto.ProjectDto;
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
class ProjectControllerTest implements DefaultTestController<ProjectDto> {

    private static final String PROJECT_ANALYTICS_ENTITY_FILE = "project.json";

    @ClassRule
    private static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.0");

    private static ProjectDto project;

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    static void setUp() throws IOException {
        mySQLContainer.start();
        System.setProperty("spring.datasource.url", mySQLContainer.getJdbcUrl());
        System.setProperty("spring.datasource.username", mySQLContainer.getUsername());
        System.setProperty("spring.datasource.password", mySQLContainer.getPassword());
        project = EntityUtil.getTestEntity(PROJECT_ANALYTICS_ENTITY_FILE, ProjectDto.class);
    }

    @Test
    @Order(1)
    void create() throws Exception {
        ProjectDto created = createEntityTest();
        project = created;
    }

    @Test
    @Order(2)
    void getById() throws Exception {
        getEntityByIdTest(project.getId());
    }

    @Test
    @Order(3)
    void update() throws Exception {
        ProjectDto updated = updateEntityTest(project.getId());
        project = updated;
    }

    @Test
    @Order(4)
    void deleteById() throws Exception {
        removeEntityByIdTest(project.getId());
    }

    @Test
    @Order(5)
    void checkIsDeleted() throws Exception {
        checkIsDeletedEntityTest(project.getId());
    }

    @AfterAll
    static void stop(){
        mySQLContainer.stop();
    }

    @Override
    public MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    public String getEntityEndpoint() {
        return "/projects";
    }

    @Override
    public String getEntityIdParam() {
        return "{projectId}";
    }

    @Override
    public ProjectDto getEntity() {
        return project;
    }

    @Override
    public Class<ProjectDto> getEntityClass() {
        return ProjectDto.class;
    }
}

