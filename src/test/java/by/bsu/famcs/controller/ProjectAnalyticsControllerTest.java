package by.bsu.famcs.controller;

import by.bsu.famcs.dto.ProjectAnalyticsDto;
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
class ProjectAnalyticsControllerTest implements DefaultTestController<ProjectAnalyticsDto> {

    private static final String PROJECT_ANALYTICS_ENTITY_FILE = "project-analytics.json";

    @ClassRule
    private static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.0");

    private static ProjectAnalyticsDto projectAnalytics;

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    static void setUp() throws IOException {
        mySQLContainer.start();
        System.setProperty("spring.datasource.url", mySQLContainer.getJdbcUrl());
        System.setProperty("spring.datasource.username", mySQLContainer.getUsername());
        System.setProperty("spring.datasource.password", mySQLContainer.getPassword());
        projectAnalytics = EntityUtil.getTestEntity(PROJECT_ANALYTICS_ENTITY_FILE, ProjectAnalyticsDto.class);
    }

    @Test
    @Order(1)
    @WithMockUser(value = DEFAULT_USER_ID, roles = EDIT_PAYMENTS)
    void create() throws Exception {
        ProjectAnalyticsDto created = createEntityTest();
        projectAnalytics = created;
    }

    @Test
    @Order(2)
    @WithMockUser(value = DEFAULT_USER_ID, roles = READ_PAYMENTS)
    void getById() throws Exception {
        getEntityByIdTest(projectAnalytics.getId());
    }

    @Test
    @Order(3)
    @WithMockUser(value = DEFAULT_USER_ID, roles = EDIT_PAYMENTS)
    void update() throws Exception {
        ProjectAnalyticsDto updated = updateEntityTest(projectAnalytics.getId());
        projectAnalytics = updated;
    }

    @Test
    @Order(4)
    @WithMockUser(value = DEFAULT_USER_ID, roles = EDIT_PAYMENTS)
    void deleteById() throws Exception {
        removeEntityByIdTest(projectAnalytics.getId());
    }

    @Test
    @Order(5)
    @WithMockUser(value = DEFAULT_USER_ID, roles = READ_PAYMENTS)
    void checkIsDeleted() throws Exception {
        checkIsDeletedEntityTest(projectAnalytics.getId());
    }

    @Override
    public MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    public String getEntityEndpoint() {
        return "/project-analytics";
    }

    @Override
    public String getEntityIdParam() {
        return "{projectAnalyticsId}";
    }

    @Override
    public ProjectAnalyticsDto getEntity() {
        return projectAnalytics;
    }

    @Override
    public Class<ProjectAnalyticsDto> getEntityClass() {
        return ProjectAnalyticsDto.class;
    }
}

