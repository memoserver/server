package com.memo.server.service.memo.pri;

import com.memo.server.entity.memo.pri.PriTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PriTagRepository extends JpaRepository<PriTag,Integer> {

    @Transactional
    void deletePriTagsByPrivateId(int privateId);
}
