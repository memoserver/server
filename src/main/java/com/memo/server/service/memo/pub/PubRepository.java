package com.memo.server.service.memo.pub;

import com.memo.server.entity.memo.pub.Pub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PubRepository extends JpaRepository<Pub,Integer> {

    void deletePubByPublic_id(int public_id);

    List<Pub> findAllByOrOrderByPublishTimeDesc();
}
