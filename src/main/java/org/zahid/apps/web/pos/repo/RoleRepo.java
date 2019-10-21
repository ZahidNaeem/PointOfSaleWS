package org.zahid.apps.web.pos.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zahid.apps.web.pos.entity.Role;
import org.zahid.apps.web.pos.enumeration.RoleName;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

  Optional<Role> findByName(RoleName roleName);
}
