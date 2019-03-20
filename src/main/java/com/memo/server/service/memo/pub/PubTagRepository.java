package com.memo.server.service.memo.pub;

import com.memo.server.entity.memo.pub.PubTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PubTagRepository extends JpaRepository<PubTag,Integer> {
    @Transactional
    void deletePubTagsByPublicId(int publicId);
}
