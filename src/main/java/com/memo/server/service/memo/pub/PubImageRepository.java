package com.memo.server.service.memo.pub;

import com.memo.server.entity.memo.pub.PubImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PubImageRepository extends JpaRepository<PubImage,Integer> {
    @Transactional
    void deletePubImagesByPublicId(int publicId);
}
