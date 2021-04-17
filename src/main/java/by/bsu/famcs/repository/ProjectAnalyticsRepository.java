package by.bsu.famcs.repository;

import by.bsu.famcs.entity.ProjectAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProjectAnalyticsRepository extends JpaRepository<ProjectAnalytics, String>, JpaSpecificationExecutor<ProjectAnalytics> {
}

