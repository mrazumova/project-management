package by.bsu.famcs.specification;

import by.bsu.famcs.entity.Department;
import by.bsu.famcs.entity.Department_;
import by.bsu.famcs.filter.DepartmentFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DepartmentSpecification implements Specification<Department> {

    private DepartmentFilter filter;

    public DepartmentSpecification(DepartmentFilter filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (filter.getName() != null)
            predicates.add(criteriaBuilder.equal(root.get(Department_.NAME), filter.getName()));

        if (filter.getManager() != null)
            predicates.add(criteriaBuilder.equal(root.get(Department_.MANAGER), filter.getManager()));

        return predicates.isEmpty() ? criteriaBuilder.conjunction() : criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
