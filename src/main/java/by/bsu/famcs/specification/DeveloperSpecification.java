package by.bsu.famcs.specification;

import by.bsu.famcs.entity.Developer;
import by.bsu.famcs.filter.DepartmentFilter;
import by.bsu.famcs.filter.DeveloperFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class DeveloperSpecification implements Specification<Developer> {

    private DeveloperFilter filter;

    public DeveloperSpecification(DeveloperFilter filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<Developer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
