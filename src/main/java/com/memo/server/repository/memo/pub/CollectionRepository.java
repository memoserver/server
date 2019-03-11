package com.memo.server.repository.memo.pub;

import com.memo.server.entity.memo.pub.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionRepository extends JpaRepository<Collection,Integer> {
}
