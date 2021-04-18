package by.bsu.famcs.specification;

import by.bsu.famcs.entity.Manager;
import by.bsu.famcs.entity.Manager_;
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

        if (filter.getName() != null)
            predicates.add(criteriaBuilder.equal(root.get(Manager_.NAME), filter.getName()));

        if (filter.getSurname() != null)
            predicates.add(criteriaBuilder.equal(root.get(Manager_.SURNAME), filter.getSurname()));

        if (filter.getPost() != null)
            predicates.add(criteriaBuilder.equal(root.get(Manager_.POST), filter.getPost()));

        if (filter.getCvLink() != null)
            predicates.add(criteriaBuilder.equal(root.get(Manager_.CV_LINK), filter.getCvLink()));

        if (filter.getWorkload() != null)
            predicates.add(criteriaBuilder.equal(root.get(Manager_.WORKLOAD), filter.getWorkload()));

        if (filter.getSalary() != null)
            predicates.add(criteriaBuilder.equal(root.get(Manager_.SALARY), filter.getSalary()));

        if (filter.getUnitId() != null)
            predicates.add(criteriaBuilder.equal(root.get(Manager_.UNIT_ID), filter.getUnitId()));

        return predicates.isEmpty() ? criteriaBuilder.conjunction() : criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
