package com.memo.server.controller;

import com.memo.server.service.memo.pri.PriRepository;
import com.memo.server.service.user.UserBaseRepository;
import com.memo.server.service.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    private final UserBaseRepository userBaseRepository;

    private final UserRepository userRepository;

    private final PriRepository priRepository;

    @Autowired
    public controller(UserBaseRepository userBaseRepository, UserRepository userRepository, PriRepository priRepository) {
        this.userBaseRepository = userBaseRepository;
        this.userRepository = userRepository;
        this.priRepository = priRepository;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
