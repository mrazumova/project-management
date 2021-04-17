package by.bsu.famcs.specification;

import by.bsu.famcs.entity.PaymentHistory;
import by.bsu.famcs.filter.PaymentHistoryFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class PaymentHistorySpecification implements Specification<PaymentHistory> {

    private PaymentHistoryFilter filter;

    public PaymentHistorySpecification(PaymentHistoryFilter filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<PaymentHistory> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
