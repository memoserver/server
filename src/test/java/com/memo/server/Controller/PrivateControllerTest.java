package com.memo.server.Controller;


import com.alibaba.fastjson.JSON;
import com.memo.server.controller.PrivateController;
import com.memo.server.controller.UserController;
import com.memo.server.entity.memo.pri.Pri;
import com.memo.server.entity.memo.pri.PriTag;
import com.memo.server.entity.user.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PrivateControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private PrivateController privateController;

    @Autowired
    private UserController userController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(privateController).build();
    }

    /**
     * 发布
     */
    @Test
    public void publish_private() throws Exception {
        int n = 10;

        List<Pri> pris = create_pri(n);

        //for (int i = 0; i < pris.size(); i++) {
        test("/publish_private", "pri", JSON.toJSONString(pris.get(0)));
        //}
    }

    private List<Pri> create_pri(int n) {
        List<Pri> pris = new ArrayList<>();

        char[] alpha = new char[26 * 2 + 10];
        for (int i = 0; i < 26; i++) {
            alpha[i] = (char) ('a' + i);
            alpha[i + 26] = (char) ('A' + i);
        }
        for (int i = 0; i < 10; i++) {
            alpha[i + 51] = (char) ('0' + i);
        }

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            Pri pri = new Pri();

            User user = userController.view_information(6);
            pri.setUser(user);

            int title_length = random.nextInt(20) + 1;
            String title = "";
            for (int j = 0; j < title_length; j++) {
                title = title + alpha[random.nextInt(62)];
            }
            pri.setTitle(title);

            int content_length = random.nextInt(80) + 1;
            String content = "";
            for (int j = 0; j < content_length / 3; j++) {
                content = content + alpha[random.nextInt(62)];
            }
            content = content + content + content;
            pri.setContent(content);

            Set<PriTag> priTags = new HashSet<>();
            PriTag priTag1 = new PriTag();
            priTag1.setTag("音乐会");
            priTags.add(priTag1);
            PriTag priTag2 = new PriTag();
            priTag2.setTag("周杰伦");
            priTags.add(priTag2);
            pri.setPriTags(priTags);

            pri.setPublishTime(new Date());

            pri.setAlarmTime(new Date());

            pri.setUrgent(random.nextBoolean());

            pris.add(pri);
        }

        return pris;
    }

    private void test(String url, String paramName, String paramValue) throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param(paramName, paramValue)
        )
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }
}
