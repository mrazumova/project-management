package by.bsu.famcs.specification;

import by.bsu.famcs.entity.ExpenseHistory;
import by.bsu.famcs.filter.ExpenseHistoryFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ExpenseHistorySpecification implements Specification<ExpenseHistory> {

    private ExpenseHistoryFilter filter;

    public ExpenseHistorySpecification(ExpenseHistoryFilter filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<ExpenseHistory> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
