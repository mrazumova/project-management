package by.bsu.famcs.controller;

import by.bsu.famcs.dto.ExpenseHistoryDto;
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
class ExpenseHistoryControllerTest implements DefaultTestController<ExpenseHistoryDto> {

    private static final String EXPENSE_HISTORY_ENTITY_FILE = "expense-history.json";

    @ClassRule
    private static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.0");

    private static ExpenseHistoryDto expenseHistory;

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    static void setUp() throws IOException {
        mySQLContainer.start();
        System.setProperty("spring.datasource.url", mySQLContainer.getJdbcUrl());
        System.setProperty("spring.datasource.username", mySQLContainer.getUsername());
        System.setProperty("spring.datasource.password", mySQLContainer.getPassword());
        expenseHistory = EntityUtil.getTestEntity(EXPENSE_HISTORY_ENTITY_FILE, ExpenseHistoryDto.class);
    }

    @Test
    @Order(1)
    void create() throws Exception {
        ExpenseHistoryDto created = createEntityTest();
        expenseHistory = created;
    }

    @Test
    @Order(2)
    void getById() throws Exception {
        getEntityByIdTest(expenseHistory.getId());
    }

    @Test
    @Order(3)
    void update() throws Exception {
        ExpenseHistoryDto updated = updateEntityTest(expenseHistory.getId());
        expenseHistory = updated;
    }

    @Test
    @Order(4)
    void deleteById() throws Exception {
        removeEntityByIdTest(expenseHistory.getId());
    }

    @Test
    @Order(5)
    void checkIsDeleted() throws Exception {
        checkIsDeletedEntityTest(expenseHistory.getId());
    }

    @Override
    public MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    public String getEntityEndpoint() {
        return "/expense-history";
    }

    @Override
    public String getEntityIdParam() {
        return "{expenseHistoryId}";
    }

    @Override
    public ExpenseHistoryDto getEntity() {
        return expenseHistory;
    }

    @Override
    public Class<ExpenseHistoryDto> getEntityClass() {
        return ExpenseHistoryDto.class;
    }
}