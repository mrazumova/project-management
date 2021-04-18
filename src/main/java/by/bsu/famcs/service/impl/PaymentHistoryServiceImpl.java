package by.bsu.famcs.service.impl;

import by.bsu.famcs.dto.PaymentHistoryDto;
import by.bsu.famcs.entity.PaymentHistory;
import by.bsu.famcs.filter.PaymentHistoryFilter;
import by.bsu.famcs.mapper.AbstractMapper;
import by.bsu.famcs.repository.PaymentHistoryRepository;
import by.bsu.famcs.service.PaymentHistoryService;
import by.bsu.famcs.specification.PaymentHistorySpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public class PaymentHistoryServiceImpl extends DefaultCrudService<PaymentHistory, PaymentHistoryDto> implements PaymentHistoryService {

    private final PaymentHistoryRepository paymentHistoryRepository;

    public PaymentHistoryServiceImpl(PaymentHistoryRepository paymentHistoryRepository, AbstractMapper<PaymentHistory, PaymentHistoryDto> mapper) {
        super(mapper);
        this.paymentHistoryRepository = paymentHistoryRepository;
    }

    @Override
    public Page<PaymentHistoryDto> findAll(PaymentHistoryFilter filter, Pageable pageable) {
        return paymentHistoryRepository.findAll(new PaymentHistorySpecification(filter), pageable).map(mapper::toDto);
    }

    @Override
    public PaymentHistoryDto update(PaymentHistoryDto dto, String entityId) {
        PaymentHistory paymentHistory = getEntity(entityId);
        update(dto, paymentHistory);
        return mapper.toDto(paymentHistoryRepository.save(paymentHistory));
    }

    public static void update(PaymentHistoryDto dto, PaymentHistory entity) {
        entity.setProjectId(dto.getProject().getId());
        entity.setAmount(dto.getAmount());
        entity.setPaymentDate(dto.getPaymentDate());
    }

    @Override
    protected CrudRepository<PaymentHistory, String> getRepository() {
        return paymentHistoryRepository;
    }
}
