package by.bsu.famcs.service;

import by.bsu.famcs.dto.PaymentHistoryDto;
import by.bsu.famcs.filter.PaymentHistoryFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaymentHistoryService extends CrudService<PaymentHistoryDto> {

    Page<PaymentHistoryDto> findAll(PaymentHistoryFilter filter, Pageable pageable);
}
