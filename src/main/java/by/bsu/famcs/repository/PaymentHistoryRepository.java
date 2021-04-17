package by.bsu.famcs.repository;

import by.bsu.famcs.entity.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, String>, JpaSpecificationExecutor<PaymentHistory> {
}
