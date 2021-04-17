package by.bsu.famcs.repository;

import by.bsu.famcs.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProjectRepository extends JpaRepository<Project, String>, JpaSpecificationExecutor<Project> {
}

