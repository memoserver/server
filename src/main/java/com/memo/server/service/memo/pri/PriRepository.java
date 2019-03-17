package com.memo.server.service.memo.pri;

import com.memo.server.entity.memo.pri.Pri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriRepository extends JpaRepository<Pri,Integer> {

    Pri findPriByPrivateId(int privateId);
}
