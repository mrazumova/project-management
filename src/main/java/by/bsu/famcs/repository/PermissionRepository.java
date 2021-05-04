package by.bsu.famcs.repository;

import by.bsu.famcs.entity.Permission;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface PermissionRepository extends CrudRepository<Permission, String> {

    @Query(value = "select * from permission p "
            + "left join role_permission rp "
            + "on p.id = rp.permission_id "
            + "left join role r "
            + "on rp.role_id = r.id "
            + "where r.name in :roles",
            nativeQuery = true)
    @Cacheable(cacheNames = "permissions", key = "#roles")
    List<Permission> findByRoles(Collection<String> roles);

}
