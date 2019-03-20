package com.memo.server.service.memo.pub;

import com.memo.server.entity.memo.pub.Pub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PubRepository extends JpaRepository<Pub,Integer> {

    List<Pub> findAllByOrderByPublishTimeDesc();

    @Transactional
    void deletePubByPublicId(int publicId);

    Pub findPubByPublicId(int publicId);
}
