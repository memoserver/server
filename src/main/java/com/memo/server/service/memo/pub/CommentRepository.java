package com.memo.server.service.memo.pub;

import com.memo.server.entity.memo.pub.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
//    void deleteCommentByUser_UserIdAndPub_Public_id(int userId, int public_id);
}
