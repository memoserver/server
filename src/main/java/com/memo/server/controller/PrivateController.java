package com.memo.server.controller;

import com.alibaba.fastjson.JSON;
import com.memo.server.entity.memo.pri.Pri;
import com.memo.server.service.memo.pri.PriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PrivateController {

    @Autowired
    private PriRepository priRepository;

    @RequestMapping(value = "publish_private")
    public Pri publish_private(@RequestParam("pri") String json) {
        Pri pri = (Pri) JSON.parse(json);
        pri = priRepository.saveAndFlush(pri);
        return pri;
    }

    @RequestMapping(value = "delete_private")
    public void delete_private(@RequestParam("private_id") int private_id) {
        priRepository.deletePriByPrivateId(private_id);
    }

    @RequestMapping(value = "get_private_order_by_urgent_and_time")
    public List<Pri> get_private_order_by_urgent_and_time(@RequestParam("user_id") int user_id) {
        List<Pri> pris = priRepository.findPrisByUserUserIdOrdOrderByUrgentDescAlarmTimeAscPublishTimeAsc(user_id);
        return pris;
    }
}
