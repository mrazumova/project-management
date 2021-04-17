package by.bsu.famcs.repository;

import by.bsu.famcs.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UnitRepository extends JpaRepository<Unit, String>, JpaSpecificationExecutor<Unit> {
}

