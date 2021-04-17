package by.bsu.famcs.specification;

import by.bsu.famcs.entity.Developer;
import by.bsu.famcs.entity.Developer_;
import by.bsu.famcs.filter.DepartmentFilter;
import by.bsu.famcs.filter.DeveloperFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DeveloperSpecification implements Specification<Developer> {

    private DeveloperFilter filter;

    public DeveloperSpecification(DeveloperFilter filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<Developer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (filter.getName() != null)
            predicates.add(criteriaBuilder.equal(root.get(Developer_.NAME), filter.getName()));

        if (filter.getSurname() != null)
            predicates.add(criteriaBuilder.equal(root.get(Developer_.SURNAME), filter.getSurname()));

        if (filter.getLevel() != null)
            predicates.add(criteriaBuilder.equal(root.get(Developer_.LEVEL), filter.getLevel()));

        if (filter.getWorkload() != null)
            predicates.add(criteriaBuilder.equal(root.get(Developer_.WORKLOAD), filter.getSalary()));

        if (filter.getSalary() != null)
            predicates.add(criteriaBuilder.equal(root.get(Developer_.SALARY), filter.getSalary()));

        if (filter.getSpecialization() != null)
            predicates.add(criteriaBuilder.equal(root.get(Developer_.SPECIALIZATION), filter.getSpecialization()));

        if (filter.getProject() != null)
            predicates.add(criteriaBuilder.equal(root.get(Developer_.PROJECT), filter.getProject()));

        if (filter.getUnit() != null)
            predicates.add(criteriaBuilder.equal(root.get(Developer_.UNIT), filter.getUnit()));

        return predicates.isEmpty() ? criteriaBuilder.conjunction() : criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
