package by.bsu.famcs.specification;

import by.bsu.famcs.entity.Manager;
import by.bsu.famcs.filter.ManagerFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ManagerSpecification implements Specification<Manager> {

    private ManagerFilter filter;

    public ManagerSpecification(ManagerFilter filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<Manager> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        return predicates.isEmpty() ? criteriaBuilder.conjunction() : criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
