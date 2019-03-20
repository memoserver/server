package com.memo.server.service.user;

import com.memo.server.entity.user.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TagRepository extends JpaRepository<Tag,Integer> {

    @Transactional
    void deleteTagsByUserId(int userId);
}
