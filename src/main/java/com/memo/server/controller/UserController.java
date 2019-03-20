package com.memo.server.controller;

import com.alibaba.fastjson.JSON;
import com.memo.server.entity.user.Follow;
import com.memo.server.entity.user.Tag;
import com.memo.server.entity.user.User;
import com.memo.server.entity.user.UserSelf;
import com.memo.server.security.SHA;
import com.memo.server.service.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    /**
     * 密码
     */
    @Autowired
    private UserSelfRepository userSelfRepository;

    /**
     * 无关注
     */
    @Autowired
    private UserBaseRepository userBaseRepository;

    /**
     * 有关注
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * 关注
     */
    @Autowired
    private FollowRepository followRepository;

    /**
     * tag
     */
    @Autowired
    private TagRepository tagRepository;

    @RequestMapping(value = "login")
    public User login(@RequestParam("account") String account, @RequestParam("password") String password) {
        // 用户名不存在
        if (!userSelfRepository.existsByAccount(account)) {
            return null;
        }

        UserSelf userSelf = userSelfRepository.findUserSelfByAccount(account);

        // 密码错误
        password = SHA.getSHA(password);
        if (!userSelf.getPassword().equals(password))
            return null;

        User user = userRepository.findUserByUserId(userSelf.getUserId());
//        System.out.println(JSON.toJSON(user));
        return user;
    }

    @RequestMapping(value = "register")
    public User register(@RequestParam("account") String account, @RequestParam("password") String password) {
        // 用户已存在
        if (userSelfRepository.existsByAccount(account)) {
            return null;
        }

        // 加密
        password = SHA.getSHA(password);

        UserSelf userSelf = new UserSelf(account, password, 0);
        userSelf = userSelfRepository.saveAndFlush(userSelf);
        return new User(userSelf.getUserId(), userSelf.getAccount());
    }

    @RequestMapping(value = "modify_information")
    public User modify_information(@RequestParam("user") String json) {
        System.out.println(json);
        User user = JSON.parseObject(json, User.class);

//        Set<Tag> tags = tagRepository.findTagsByUserId(user.getUserId());
//        tagRepository.deleteAll(tags);
        tagRepository.deleteTagsByUserId(user.getUserId());

//        user = userRepository.saveAndFlush(user);

        return userRepository.findUserByUserId(user.getUserId());
    }

    @RequestMapping(value = "add_tag")
    public User add_tag(@RequestParam("tag") String json) {
        Tag tag = JSON.parseObject(json, Tag.class);
        tag = tagRepository.saveAndFlush(tag);
        return userRepository.findUserByUserId(tag.getUserId());
    }

    @RequestMapping(value = "delete_tag")
    public User delete_tag(@RequestParam("tag") String json) {
        Tag tag = JSON.parseObject(json, Tag.class);
        tagRepository.delete(tag);
        return userRepository.findUserByUserId(tag.getUserId());
    }

    @RequestMapping(value = "add_following")
    public User add_following(@RequestParam("follow") String json) {
        Follow follow = JSON.parseObject(json, Follow.class);
        follow = followRepository.saveAndFlush(follow);
        return userRepository.findUserByUserId(follow.getFollowingUserId());
    }

    @RequestMapping(value = "delete_following")
    public User delete_following(@RequestParam("follow") String json) {
        Follow follow = JSON.parseObject(json, Follow.class);
        followRepository.delete(follow);
        return userRepository.findUserByUserId(follow.getFollowingUserId());
    }

    @RequestMapping(value = "view_information")
    public User view_information(@RequestParam("user_id") int user_id) {
        User user = userRepository.findUserByUserId(user_id);
        return user;
    }
}
