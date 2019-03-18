package com.memo.server.controller;

import com.alibaba.fastjson.JSON;
import com.memo.server.entity.memo.pub.Collection;
import com.memo.server.entity.memo.pub.Comment;
import com.memo.server.entity.memo.pub.Joining;
import com.memo.server.entity.memo.pub.Pub;
import com.memo.server.service.memo.pub.CollectionRepository;
import com.memo.server.service.memo.pub.CommentRepository;
import com.memo.server.service.memo.pub.JoiningRepository;
import com.memo.server.service.memo.pub.PubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class PublicController {
    @Autowired
    private PubRepository pubRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private JoiningRepository joiningRepository;

    @Autowired
    private CollectionRepository collectionRepository;

    @RequestMapping(value = "publish_public")
    public Pub publish_public(@RequestParam("pub") String json) {
        Pub pub = (Pub) JSON.parse(json);
        pub.setPublishTime(new Date());
        pub = pubRepository.saveAndFlush(pub);
        return pub;
    }

    @RequestMapping(value = "delete_public")
    public void delete_public(@RequestParam("public_id") int public_id) {
//        pubRepository.deletePubByPublic_id(public_id);
    }

    @RequestMapping(value = "get_public_order_by_time")
    public List<Pub> get_public_order_by_time(@RequestParam("user_id") int user_id) {
        List<Pub> pubs = pubRepository.findAllByOrderByPublishTimeDesc();
        return pubs;
    }

    @RequestMapping(value = "publish_comment")
    public Comment publish_comment(@RequestParam("comment") String json) {
        Comment comment = (Comment) JSON.parse(json);
        comment.setTime(new Date());
        comment = commentRepository.saveAndFlush(comment);
        return comment;
    }

    @RequestMapping(value = "delete_comment")
    public void delete_comment(@RequestParam("user_id") int user_id, @RequestParam("public_id") int public_id) {
//        commentRepository.deleteCommentByUser_UserIdAndPub_Public_id(user_id, public_id);
    }

    @RequestMapping(value = "join")
    public Joining join(@RequestParam("join") String json) {
        Joining joining = (Joining) JSON.parse(json);
        joining.setTime(new Date());
        joining = joiningRepository.saveAndFlush(joining);
        return joining;
    }

    @RequestMapping(value = "not_join")
    public void not_join(@RequestParam("user_id") int user_id, @RequestParam("public_id") int public_id) {
//        joiningRepository.deleteJoiningByUser_UserIdAndPub_Public_id(user_id, public_id);
    }

    @RequestMapping(value = "collect")
    public Collection collect(@RequestParam("collection") String json) {
        Collection collection = (Collection) JSON.parse(json);
        collection.setTime(new Date());
        collection = collectionRepository.saveAndFlush(collection);
        return collection;
    }

    @RequestMapping(value = "not_collect")
    public void not_collect(@RequestParam("collection") String json) {
        Collection collection = (Collection) JSON.parse(json);
        collectionRepository.delete(collection);
    }
}
