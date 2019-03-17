package com.memo.server.service.user;

import com.memo.server.entity.user.UserSelf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSelfRepository extends JpaRepository<UserSelf,Integer> {

    UserSelf findUserSelfByAccount(String account);

    boolean existsByAccount(String accout);
}
