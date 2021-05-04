package by.bsu.famcs.security;

import by.bsu.famcs.entity.Permission;
import by.bsu.famcs.repository.PermissionRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PermissionAuthorityMapper implements GrantedAuthoritiesMapper {

    private final PermissionRepository permissionRepository;

    private final String rolePrefix;

    public PermissionAuthorityMapper(PermissionRepository permissionRepository) {
        this(permissionRepository, "ROLE_");
    }

    public PermissionAuthorityMapper(PermissionRepository permissionRepository, String rolePrefix) {
        super();
        this.permissionRepository = permissionRepository;
        this.rolePrefix = rolePrefix;
    }

    @Override
    public Collection<? extends GrantedAuthority> mapAuthorities(Collection<? extends GrantedAuthority> authorities) {
        Set<String> roles = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .map(String::toUpperCase)
                .collect(Collectors.toCollection(TreeSet::new));

        List<GrantedAuthority> mapped = permissionRepository.findByRoles(roles).stream()
                .map(Permission::getName)
                .map(String::toUpperCase)
                .distinct()
                .map(p -> this.rolePrefix + p)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return mapped;
    }

}
