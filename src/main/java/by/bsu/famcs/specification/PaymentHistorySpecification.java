package by.bsu.famcs.specification;

import by.bsu.famcs.entity.PaymentHistory;
import by.bsu.famcs.entity.PaymentHistory_;
import by.bsu.famcs.filter.PaymentHistoryFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PaymentHistorySpecification implements Specification<PaymentHistory> {

    private PaymentHistoryFilter filter;

    public PaymentHistorySpecification(PaymentHistoryFilter filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<PaymentHistory> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (filter.getPaymentDate() != null)
            predicates.add(criteriaBuilder.equal(root.get(PaymentHistory_.PAYMENT_DATE), filter.getPaymentDate()));

        if (filter.getAmount() != null)
            predicates.add(criteriaBuilder.equal(root.get(PaymentHistory_.AMOUNT), filter.getAmount()));

        if (filter.getProject() != null)
            predicates.add(criteriaBuilder.equal(root.get(PaymentHistory_.PROJECT), filter.getProject()));

        return predicates.isEmpty() ? criteriaBuilder.conjunction() : criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
