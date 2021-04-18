package by.bsu.famcs.specification;

import by.bsu.famcs.entity.ExpenseHistory;
import by.bsu.famcs.entity.ExpenseHistory_;
import by.bsu.famcs.filter.ExpenseHistoryFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ExpenseHistorySpecification implements Specification<ExpenseHistory> {

    private ExpenseHistoryFilter filter;

    public ExpenseHistorySpecification(ExpenseHistoryFilter filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<ExpenseHistory> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (filter.getExpenseDate() != null)
            predicates.add(criteriaBuilder.equal(root.get(ExpenseHistory_.EXPENSE_DATE), filter.getExpenseDate()));

        if (filter.getAmount() != null)
            predicates.add(criteriaBuilder.equal(root.get(ExpenseHistory_.AMOUNT), filter.getAmount()));

        if (filter.getProjectId() != null)
            predicates.add(criteriaBuilder.equal(root.get(ExpenseHistory_.PROJECT_ID), filter.getProjectId()));

        return predicates.isEmpty() ? criteriaBuilder.conjunction() : criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
