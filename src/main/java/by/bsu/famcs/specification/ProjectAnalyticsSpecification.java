package by.bsu.famcs.specification;

import by.bsu.famcs.entity.ProjectAnalytics;
import by.bsu.famcs.filter.ProjectAnalyticsFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ProjectAnalyticsSpecification implements Specification<ProjectAnalytics> {

    private ProjectAnalyticsFilter filter;

    public ProjectAnalyticsSpecification(ProjectAnalyticsFilter filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<ProjectAnalytics> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
