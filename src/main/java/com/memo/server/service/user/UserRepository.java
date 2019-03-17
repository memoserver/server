package com.memo.server.service.user;

import com.memo.server.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserByUserId(int userId);

    User findUserByAccount(String account);
}
