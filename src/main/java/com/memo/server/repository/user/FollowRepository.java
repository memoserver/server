package com.memo.server.repository.user;

import com.memo.server.entity.user.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow,Integer> {

}
