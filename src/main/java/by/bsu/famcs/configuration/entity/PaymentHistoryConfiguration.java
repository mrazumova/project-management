package by.bsu.famcs.configuration.entity;

import by.bsu.famcs.repository.PaymentHistoryRepository;
import by.bsu.famcs.service.PaymentHistoryService;
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
    public PaymentHistoryService paymentHistoryService() {
        return new PaymentHistoryServiceImpl(paymentHistoryRepository);
    }
}
