package com.memo.server.controller;

import com.memo.server.entity.memo.pri.Pri;
import com.memo.server.entity.user.User;
import com.memo.server.entity.user.UserBase;
import com.memo.server.service.memo.pri.PriRepository;
import com.memo.server.service.user.UserBaseRepository;
import com.memo.server.service.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    private final UserBaseRepository userB-aseRepository;

    private final UserRepository userRepository;

    private final PriRepository priRepository;

    @Autowired
    public controller(UserBaseRepository userBaseRepository, UserRepository userRepository, PriRepository priRepository) {
        this.userBaseRepository = userBaseRepository;
        this.userRepository = userRepository;
        this.priRepository = priRepository;
    }

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

        System.out.println(userRepository.findUserByUserId(1));
        return userRepository.findUserByUserId(1);
    }


    @RequestMapping("/pri")
    public Pri getPri() {
        System.out.println(priRepository.findAll());
        return priRepository.findPriByPrivateId(1);
    }
}
