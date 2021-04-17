package by.bsu.famcs.specification;

import by.bsu.famcs.entity.Unit;
import by.bsu.famcs.entity.Unit_;
import by.bsu.famcs.filter.UnitFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class UnitSpecification implements Specification<Unit> {

    private UnitFilter filter;

    public UnitSpecification(UnitFilter filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<Unit> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (filter.getName() != null)
            predicates.add(criteriaBuilder.equal(root.get(Unit_.NAME), filter.getName()));

        if (filter.getDepartment() != null)
            predicates.add(criteriaBuilder.equal(root.get(Unit_.DEPARTMENT), filter.getDepartment()));

        if (filter.getManager() != null)
            predicates.add(criteriaBuilder.equal(root.get(Unit_.MANAGER), filter.getManager()));

        return predicates.isEmpty() ? criteriaBuilder.conjunction() : criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
