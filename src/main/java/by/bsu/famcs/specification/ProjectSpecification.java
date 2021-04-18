package by.bsu.famcs.specification;

import by.bsu.famcs.entity.Project;
import by.bsu.famcs.entity.Project_;
import by.bsu.famcs.filter.ProjectFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProjectSpecification implements Specification<Project> {

    private ProjectFilter filter;

    public ProjectSpecification(ProjectFilter filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (filter.getName() != null)
            predicates.add(criteriaBuilder.equal(root.get(Project_.NAME), filter.getName()));

        if (filter.getStatus() != null)
            predicates.add(criteriaBuilder.equal(root.get(Project_.STATUS), filter.getStatus()));

        if (filter.getType() != null)
            predicates.add(criteriaBuilder.equal(root.get(Project_.TYPE), filter.getType()));

        if (filter.getPricingModel() != null)
            predicates.add(criteriaBuilder.equal(root.get(Project_.PRICING_MODEL), filter.getPricingModel()));

        if (filter.getManagerId() != null)
            predicates.add(criteriaBuilder.equal(root.get(Project_.MANAGER_ID), filter.getManagerId()));

        if (filter.getStarted() != null)
            predicates.add(criteriaBuilder.equal(root.get(Project_.STARTED), filter.getStarted()));

        if (filter.getFinished() != null)
            predicates.add(criteriaBuilder.equal(root.get(Project_.FINISHED), filter.getFinished()));

        if (filter.getSupportType() != null)
            predicates.add(criteriaBuilder.equal(root.get(Project_.SUPPORT_TYPE), filter.getSupportType()));

        return predicates.isEmpty() ? criteriaBuilder.conjunction() : criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
