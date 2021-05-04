package by.bsu.famcs.controller;

import by.bsu.famcs.dto.PaymentHistoryDto;
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
class PaymentHistoryControllerTest implements DefaultTestController<PaymentHistoryDto> {

    private static final String PAYMENT_HISTORY_ENTITY_FILE = "payment-history.json";

    @ClassRule
    private static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.0");

    private static PaymentHistoryDto paymentHistory;

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    static void setUp() throws IOException {
        mySQLContainer.start();
        System.setProperty("spring.datasource.url", mySQLContainer.getJdbcUrl());
        System.setProperty("spring.datasource.username", mySQLContainer.getUsername());
        System.setProperty("spring.datasource.password", mySQLContainer.getPassword());
        paymentHistory = EntityUtil.getTestEntity(PAYMENT_HISTORY_ENTITY_FILE, PaymentHistoryDto.class);
    }

    @Test
    @Order(1)
    @WithMockUser(value = DEFAULT_USER_ID, roles = EDIT_PAYMENTS)
    void create() throws Exception {
        PaymentHistoryDto created = createEntityTest();
        paymentHistory = created;
    }

    @Test
    @Order(2)
    @WithMockUser(value = DEFAULT_USER_ID, roles = READ_PAYMENTS)
    void getById() throws Exception {
        getEntityByIdTest(paymentHistory.getId());
    }

    @Test
    @Order(3)
    @WithMockUser(value = DEFAULT_USER_ID, roles = EDIT_PAYMENTS)
    void update() throws Exception {
        PaymentHistoryDto updated = updateEntityTest(paymentHistory.getId());
        paymentHistory = updated;
    }

    @Test
    @Order(4)
    @WithMockUser(value = DEFAULT_USER_ID, roles = EDIT_PAYMENTS)
    void deleteById() throws Exception {
        removeEntityByIdTest(paymentHistory.getId());
    }

    @Test
    @Order(5)
    @WithMockUser(value = DEFAULT_USER_ID, roles = READ_PAYMENTS)
    void checkIsDeleted() throws Exception {
        checkIsDeletedEntityTest(paymentHistory.getId());
    }

    @Override
    public MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    public String getEntityEndpoint() {
        return "/payment-history";
    }

    @Override
    public String getEntityIdParam() {
        return "{paymentHistoryId}";
    }

    @Override
    public PaymentHistoryDto getEntity() {
        return paymentHistory;
    }

    @Override
    public Class<PaymentHistoryDto> getEntityClass() {
        return PaymentHistoryDto.class;
    }
}

