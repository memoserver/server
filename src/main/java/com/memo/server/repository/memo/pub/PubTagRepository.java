package com.memo.server.repository.memo.pub;

import com.memo.server.entity.memo.pub.PubTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PubTagRepository extends JpaRepository<PubTag,Integer> {
}
