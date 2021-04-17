package by.bsu.famcs.repository;

import by.bsu.famcs.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DeveloperRepository extends JpaRepository<Developer, String>, JpaSpecificationExecutor<Developer> {
}
