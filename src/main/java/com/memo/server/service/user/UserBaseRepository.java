package com.memo.server.service.user;

import com.memo.server.entity.user.UserBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Inheritance;

@Repository
@Inheritance
public interface UserBaseRepository extends JpaRepository<UserBase,Integer> {

    UserBase findUserBaseByUserId(int userId);

    UserBase findUserBaseByAccount(String account);
}
