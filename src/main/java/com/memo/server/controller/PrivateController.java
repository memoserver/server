package com.memo.server.controller;

import com.alibaba.fastjson.JSON;
import com.memo.server.entity.memo.pri.Pri;
import com.memo.server.entity.memo.pri.PriImage;
import com.memo.server.entity.memo.pri.PriTag;
import com.memo.server.service.memo.pri.PriImageRepository;
import com.memo.server.service.memo.pri.PriRepository;
import com.memo.server.service.memo.pri.PriTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class PrivateController {

    @Autowired
    private PriRepository priRepository;

    @Autowired
    private PriTagRepository priTagRepository;

    @Autowired
    private PriImageRepository priImageRepository;

    @RequestMapping(value = "publish_private")
    public Pri publish_private(@RequestParam("pri") String json) {
        Pri pri = JSON.parseObject(json, Pri.class);
        Set<PriImage> priImages = pri.getPriImages();
        Set<PriTag> priTags = pri.getPriTags();
        pri.setPriImages(null);
        pri.setPriTags(null);
        pri = priRepository.saveAndFlush(pri);
        if (priImages != null) {
            for (PriImage priImage : priImages) {
                priImage.setPrivate_id(pri.getPrivateId());
                priImageRepository.saveAndFlush(priImage);
            }
        }
        if (priTags != null) {
            for (PriTag priTag : priTags) {
                priTag.setPrivate_id(pri.getPrivateId());
                priTagRepository.saveAndFlush(priTag);
            }
        }
        return priRepository.findPriByPrivateId(pri.getPrivateId());
    }

    @RequestMapping(value = "delete_private")
    public void delete_private(@RequestParam("private_id") int private_id) {
        priRepository.deletePriByPrivateId(private_id);
    }

    @RequestMapping(value = "get_private_order_by_urgent_and_time")
    public List<Pri> get_private_order_by_urgent_and_time(@RequestParam("user_id") int user_id) {
        List<Pri> pris = priRepository.findPrisByUserUserIdOrderByUrgentDescAlarmTimeAscPublishTimeAsc(user_id);
        return pris;
    }
}
