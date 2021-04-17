package by.bsu.famcs.repository;

import by.bsu.famcs.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ManagerRepository extends JpaRepository<Manager, String>, JpaSpecificationExecutor<Manager> {
}
