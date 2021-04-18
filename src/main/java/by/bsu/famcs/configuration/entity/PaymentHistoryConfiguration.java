package by.bsu.famcs.configuration.entity;

import by.bsu.famcs.dto.PaymentHistoryDto;
import by.bsu.famcs.entity.PaymentHistory;
import by.bsu.famcs.mapper.AbstractMapper;
import by.bsu.famcs.mapper.impl.PaymentHistoryMapper;
import by.bsu.famcs.repository.PaymentHistoryRepository;
import by.bsu.famcs.service.PaymentHistoryService;
import by.bsu.famcs.service.ProjectService;
import by.bsu.famcs.service.impl.PaymentHistoryServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentHistoryConfiguration {

    private final PaymentHistoryRepository paymentHistoryRepository;

    public PaymentHistoryConfiguration(PaymentHistoryRepository paymentHistoryRepository) {
        this.paymentHistoryRepository = paymentHistoryRepository;
    }

    @Bean
    public AbstractMapper<PaymentHistory, PaymentHistoryDto> paymentHistoryMapper(ProjectService projectService) {
        return new PaymentHistoryMapper(projectService);
    }

    @Bean
    public PaymentHistoryService paymentHistoryService(AbstractMapper<PaymentHistory, PaymentHistoryDto> paymentHistoryMapper) {
        return new PaymentHistoryServiceImpl(paymentHistoryRepository, paymentHistoryMapper);
    }
}
