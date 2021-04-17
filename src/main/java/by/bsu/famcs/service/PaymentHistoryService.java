package by.bsu.famcs.service;

import by.bsu.famcs.entity.PaymentHistory;
import by.bsu.famcs.filter.PaymentHistoryFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaymentHistoryService extends CrudService<PaymentHistory> {

    Page<PaymentHistory> findAll(PaymentHistoryFilter filter, Pageable pageable);
}
