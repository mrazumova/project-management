package by.bsu.famcs.service.impl;

import by.bsu.famcs.entity.PaymentHistory;
import by.bsu.famcs.filter.PaymentHistoryFilter;
import by.bsu.famcs.repository.PaymentHistoryRepository;
import by.bsu.famcs.service.PaymentHistoryService;
import by.bsu.famcs.specification.PaymentHistorySpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public class PaymentHistoryServiceImpl extends DefaultCrudService<PaymentHistory> implements PaymentHistoryService {

    private final PaymentHistoryRepository paymentHistoryRepository;

    public PaymentHistoryServiceImpl(PaymentHistoryRepository paymentHistoryRepository) {
        this.paymentHistoryRepository = paymentHistoryRepository;
    }

    @Override
    public Page<PaymentHistory> findAll(PaymentHistoryFilter filter, Pageable pageable) {
        return paymentHistoryRepository.findAll(new PaymentHistorySpecification(filter), pageable);
    }

    @Override
    public PaymentHistory update(PaymentHistory entity, String entityId) {
        PaymentHistory paymentHistory = getEntity(entityId);
        update(entity, paymentHistory);
        return paymentHistoryRepository.save(paymentHistory);
    }

    public static void update(PaymentHistory entity, PaymentHistory toUpdate) {
        toUpdate.setProject(entity.getProject());
        toUpdate.setAmount(entity.getAmount());
        toUpdate.setPaymentDate(entity.getPaymentDate());
    }

    @Override
    protected CrudRepository<PaymentHistory, String> getRepository() {
        return paymentHistoryRepository;
    }
}
