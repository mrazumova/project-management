package by.bsu.famcs.specification;

import by.bsu.famcs.entity.Project;
import by.bsu.famcs.filter.ProjectFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ProjectSpecification implements Specification<Project> {

    private ProjectFilter filter;

    public ProjectSpecification(ProjectFilter filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
