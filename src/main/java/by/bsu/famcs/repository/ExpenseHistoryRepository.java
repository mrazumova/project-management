package by.bsu.famcs.repository;

import by.bsu.famcs.entity.ExpenseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ExpenseHistoryRepository extends JpaRepository<ExpenseHistory, String>, JpaSpecificationExecutor<ExpenseHistory> {
}

