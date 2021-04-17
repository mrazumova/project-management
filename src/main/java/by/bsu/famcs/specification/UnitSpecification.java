package by.bsu.famcs.specification;

import by.bsu.famcs.entity.Unit;
import by.bsu.famcs.filter.UnitFilter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class UnitSpecification implements Specification<Unit> {

    private UnitFilter filter;

    public UnitSpecification(UnitFilter filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<Unit> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
