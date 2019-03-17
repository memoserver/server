package com.memo.server.controller;

import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @RequestMapping(value = "login")
    public List<Student> addMoreStudents(@RequestParam("account")String account,@RequestParam("password") String password){
        System.out.println("add_more_students（）方法");
        List<Student> studentList = (List<Student>) JSONArray.parseArray(str,Student.class);
        if(null != studentList){
            for(int i = 0;i<studentList.size();i++){
                insertInto(studentList.get(i).getName(),studentList.get(i).getAge());
            }
        }
        return studentRepository.findAll();
    }
}
