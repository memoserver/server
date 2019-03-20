package com.memo.server.service.memo.pub;

import com.memo.server.entity.memo.pub.Joining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface JoiningRepository extends JpaRepository<Joining,Integer> {

    @Transactional
    void deleteJoiningByJoiningId(int joiningId);

    @Transactional
    void deleteJoiningsByPub_PublicId(int publicId);
}
