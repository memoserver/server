package com.memo.server.service.memo.pri;

import com.memo.server.entity.memo.pri.PriImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PriImageRepository extends JpaRepository<PriImage,Integer> {

    @Transactional
    void deletePriImagesByPrivateId(int privateId);

}
