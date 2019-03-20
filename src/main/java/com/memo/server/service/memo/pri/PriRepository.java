package com.memo.server.service.memo.pri;

import com.memo.server.entity.memo.pri.Pri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PriRepository extends JpaRepository<Pri,Integer> {

    @Transactional
    void deletePriByPrivateId(int privateId);

    List<Pri> findPrisByUserUserIdOrderByUrgentDescAlarmTimeAscPublishTimeDesc(int userId);
}
