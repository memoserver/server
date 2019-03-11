package com.memo.server.repository.memo.pri;

import com.memo.server.entity.memo.pri.PriImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriImageRepository extends JpaRepository<PriImage,Integer> {

}
