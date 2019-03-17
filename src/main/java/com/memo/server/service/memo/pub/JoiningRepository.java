package com.memo.server.service.memo.pub;

import com.memo.server.entity.memo.pub.Joining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoiningRepository extends JpaRepository<Joining,Integer> {
}
