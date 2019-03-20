package com.memo.server.service.user;

import com.memo.server.entity.user.UserBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBaseRepository extends JpaRepository<UserBase,Integer> {

}
