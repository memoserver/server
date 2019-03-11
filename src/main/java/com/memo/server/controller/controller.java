package com.memo.server.controller;

import com.memo.server.entity.user.User;
import com.memo.server.entity.user.UserBase;
import com.memo.server.repository.user.UserBaseRepository;
import com.memo.server.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @Autowired
    private UserBaseRepository userBaseRepository;

    @Autowired
    private  UserRepository userRepository;

    //@GetMapping(value = "/hello")
    @RequestMapping("/userbase")
    public UserBase getUserBase() {
//        user user = new user();
//        user.setAccount("12345678910");
//        user.setPassword("987654");
//        user.setAccountType(0);
//        user.setPhone("100111");
//        user user2 = userRepository.findByUserId(1);
//        List<user> following = new ArrayList<user>();
//        following.add(user2);
//        user.setFollowing(following);
//
//        userRepository.save(user);

        System.out.println(userBaseRepository.findUserBaseByUserId(4));
        return userBaseRepository.findUserBaseByUserId(4);
    }

    @RequestMapping("/user")
    public User getUser() {

        System.out.println(userRepository.findUserByUserId(4));
        return userRepository.findUserByUserId(4);
    }
}
