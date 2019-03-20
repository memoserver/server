package com.memo.server.service.memo.pub;

import com.memo.server.entity.memo.pub.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CollectionRepository extends JpaRepository<Collection,Integer> {

    @Transactional
    void deleteCollectionByCollectionId(int collectionId);

    @Transactional
    void deleteCollectionsByPub_PublicId(int publicId);
}
