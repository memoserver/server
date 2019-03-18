package com.memo.server.controller;

import com.alibaba.fastjson.JSON;
import com.memo.server.entity.user.Follow;
import com.memo.server.entity.user.User;
import com.memo.server.entity.user.UserSelf;
import com.memo.server.security.SHA;
import com.memo.server.service.user.FollowRepository;
import com.memo.server.service.user.UserBaseRepository;
import com.memo.server.service.user.UserRepository;
import com.memo.server.service.user.UserSelfRepository;
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
    private FollowRepository followRepository;

    @RequestMapping(value = "login")
    public User login(@RequestParam("account") String account, @RequestParam("password") String password) {

        // 用户名不存在
        if (!userSelfRepository.existsByAccount(account)) {
            System.out.println(3);
            return null;
        }
        UserSelf userSelf = userSelfRepository.findUserSelfByAccount(account);

        // 密码错误
        //password = SHA.getSHA(password);
        if (!userSelf.getPassword().equals(password))
            return null;

        User user = userRepository.findUserByUserId(userSelf.getUserId());
        return user;
//        return userRepository.findUserByAccount("abcdefg");
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
        User user = (User) JSON.parse(json);
        user = userRepository.saveAndFlush(user);

        return user;
    }

    @RequestMapping(value = "add_following")
    public User add_following(@RequestParam("user_id") int user_id, @RequestParam("other_id") int other_id) {
        Follow follow = new Follow(user_id, other_id);
        follow = followRepository.saveAndFlush(follow);

        User user = userRepository.findUserByUserId(user_id);
        return user;
    }

    @RequestMapping(value = "view_information")
    public User view_information(@RequestParam("user_id") int user_id) {
        User user = userRepository.findUserByUserId(user_id);
        return user;
    }
}
