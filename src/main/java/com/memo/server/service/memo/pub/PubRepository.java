package com.memo.server.service.memo.pub;

import com.memo.server.entity.memo.pub.Pub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PubRepository extends JpaRepository<Pub,Integer> {
}
