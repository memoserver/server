package com.memo.server.repository.memo.pub;

import com.memo.server.entity.memo.pub.PubImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PubImageRepository extends JpaRepository<PubImage,Integer> {
}
