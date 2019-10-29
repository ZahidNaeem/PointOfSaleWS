package org.zahid.apps.web.pos.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.zahid.apps.web.pos.entity.UserDetail;

public interface UserDetailRepo extends JpaRepository<UserDetail, Long> {
    List<UserDetail> findByUName(String uName);

//    UserDetail findUniqueUserByUName(String uName);
}
