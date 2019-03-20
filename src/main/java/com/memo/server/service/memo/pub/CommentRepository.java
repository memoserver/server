package com.memo.server.service.memo.pub;

import com.memo.server.entity.memo.pub.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {

    @Transactional
    void deleteCommentByCommentId(int commentId);

    @Transactional
    void deleteCommentsByPub_PublicId(int publicId);
}
