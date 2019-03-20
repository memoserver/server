package com.memo.server.controller;

import com.alibaba.fastjson.JSON;
import com.memo.server.entity.memo.pub.*;
import com.memo.server.service.memo.pub.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
public class PublicController {
    @Autowired
    private PubRepository pubRepository;

    @Autowired
    private PubImageRepository pubImageRepository;

    @Autowired
    private PubTagRepository pubTagRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private JoiningRepository joiningRepository;

    @Autowired
    private CollectionRepository collectionRepository;

    @RequestMapping(value = "publish_public")
    public Pub publish_public(@RequestParam("pub") String json) {
        Pub pub = JSON.parseObject(json, Pub.class);
        pub.setPublishTime(new Date());

        Set<PubImage> pubImages = pub.getPubImages();
        Set<PubTag> pubTags = pub.getPubTags();
        pub.setPubImages(null);
        pub.setPubTags(null);

        pub = pubRepository.saveAndFlush(pub);

        if (pubImages != null) {
            for (PubImage pubImage : pubImages) {
                pubImage.setPublicId(pub.getPublicId());
                pubImageRepository.saveAndFlush(pubImage);
            }
        }

        if (pubTags != null) {
            for (PubTag pubTag : pubTags) {
                pubTag.setPublicId(pub.getPublicId());
                pubTagRepository.saveAndFlush(pubTag);
            }
        }

        pub.setPubImages(pubImages);
        pub.setPubTags(pubTags);
        return pub;
    }

    @RequestMapping(value = "delete_public")
    public void delete_public(@RequestParam("public_id") int public_id) {
        pubImageRepository.deletePubImagesByPublicId(public_id);
        pubTagRepository.deletePubTagsByPublicId(public_id);
        commentRepository.deleteCommentsByPub_PublicId(public_id);
        joiningRepository.deleteJoiningsByPub_PublicId(public_id);
        collectionRepository.deleteCollectionsByPub_PublicId(public_id);
        pubRepository.deletePubByPublicId(public_id);
    }

    @RequestMapping(value = "get_public_order_by_time")
    public List<Pub> get_public_order_by_time() {
        List<Pub> pubs = pubRepository.findAllByOrderByPublishTimeDesc();
        System.out.println(JSON.toJSONString(pubs.get(10)));
        return pubRepository.findAllByOrderByPublishTimeDesc();
    }

    @RequestMapping(value = "publish_comment")
    public Comment publish_comment(@RequestParam("comment") String json) {
        Comment comment = JSON.parseObject(json, Comment.class);
        comment.setTime(new Date());
        return commentRepository.saveAndFlush(comment);
    }

    @RequestMapping(value = "delete_comment")
    public void delete_comment(@RequestParam("comment_id") int comment_id) {
        commentRepository.deleteCommentByCommentId(comment_id);
    }

    @RequestMapping(value = "join")
    public Joining join(@RequestParam("joining") String json) {
        Joining joining = JSON.parseObject(json, Joining.class);
        joining.setTime(new Date());
        return joiningRepository.saveAndFlush(joining);
    }

    @RequestMapping(value = "not_join")
    public void not_join(@RequestParam("joining_id") int joining_id) {
        joiningRepository.deleteJoiningByJoiningId(joining_id);
    }

    @RequestMapping(value = "collect")
    public Collection collect(@RequestParam("collection") String json) {
        Collection collection = JSON.parseObject(json, Collection.class);
        collection.setTime(new Date());
        return collectionRepository.saveAndFlush(collection);
    }

    @RequestMapping(value = "not_collect")
    public void not_collect(@RequestParam("collection_id") int collection_id) {
        collectionRepository.deleteCollectionByCollectionId(collection_id);
    }
}
