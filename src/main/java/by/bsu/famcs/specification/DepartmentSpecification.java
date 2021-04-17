package by.bsu.famcs.specification;

import by.bsu.famcs.entity.Department;
import by.bsu.famcs.filter.DepartmentFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class DepartmentSpecification implements Specification<Department> {

    private DepartmentFilter filter;

    public DepartmentSpecification(DepartmentFilter filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
