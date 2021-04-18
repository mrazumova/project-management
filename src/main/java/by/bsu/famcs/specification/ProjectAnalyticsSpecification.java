package by.bsu.famcs.specification;

import by.bsu.famcs.entity.ProjectAnalytics;
import by.bsu.famcs.entity.ProjectAnalytics_;
import by.bsu.famcs.filter.ProjectAnalyticsFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProjectAnalyticsSpecification implements Specification<ProjectAnalytics> {

    private ProjectAnalyticsFilter filter;

    public ProjectAnalyticsSpecification(ProjectAnalyticsFilter filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<ProjectAnalytics> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (filter.getAlreadyReceived() != null)
            predicates.add(criteriaBuilder.equal(root.get(ProjectAnalytics_.ALREADY_RECEIVED), filter.getAlreadyReceived()));

        if (filter.getAlreadySpent() != null)
            predicates.add(criteriaBuilder.equal(root.get(ProjectAnalytics_.ALREADY_SPENT), filter.getAlreadySpent()));

        if (filter.getForecastedCost() != null)
            predicates.add(criteriaBuilder.equal(root.get(ProjectAnalytics_.FORECASTED_COST), filter.getForecastedCost()));

        if (filter.getProjectId() != null)
            predicates.add(criteriaBuilder.equal(root.get(ProjectAnalytics_.PROJECT_ID), filter.getProjectId()));

        return predicates.isEmpty() ? criteriaBuilder.conjunction() : criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
