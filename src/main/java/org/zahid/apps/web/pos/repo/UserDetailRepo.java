package org.zahid.apps.web.pos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zahid.apps.web.pos.entity.UserDetail;

import java.util.List;

public interface UserDetailRepo extends JpaRepository<UserDetail, Long> {
    List<UserDetail> findByUName(String uName);

//    UserDetail findUniqueUserByUName(String uName);
}
