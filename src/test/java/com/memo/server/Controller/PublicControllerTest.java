package com.memo.server.Controller;

import com.alibaba.fastjson.JSON;
import com.memo.server.controller.PublicController;
import com.memo.server.controller.UserController;
import com.memo.server.entity.memo.pub.Collection;
import com.memo.server.entity.memo.pub.*;
import com.memo.server.entity.user.User;
import com.memo.server.service.memo.pub.PubRepository;
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
public class PublicControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private PublicController publicController;

    @Autowired
    private UserController userController;

    @Autowired
    private PubRepository pubRepository;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(publicController).build();
    }

    /**
     * 发布
     */
    @Test
    public void publish_public() throws Exception {
        int n = 10;
        List<Pub> pubs = create_pub(n);
        for (int i = 0; i < pubs.size(); i++)
            test("/publish_public", "pub", JSON.toJSONString(pubs.get(i)));
    }

    private List<Pub> create_pub(int n) {
        List<Pub> pubs = new ArrayList<>();

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
            Pub pub = new Pub();

            User user = userController.view_information(6);
            pub.setUser(user);

            int title_length = random.nextInt(20) + 1;
            String title = "";
            for (int j = 0; j < title_length; j++) {
                title = title + alpha[random.nextInt(62)];
            }
            pub.setTitle(title);

            int content_length = random.nextInt(80) + 1;
            String content = "";
            for (int j = 0; j < content_length / 3; j++) {
                content = content + alpha[random.nextInt(62)];
            }
            content = content + content + content;
            pub.setContent(content);

            Set<PubTag> pubTags = new HashSet<>();
            PubTag pubTag1 = new PubTag();
            pubTag1.setTag("音乐会");
            pubTags.add(pubTag1);
            PubTag pubTag2 = new PubTag();
            pubTag2.setTag("周杰伦");
            pubTags.add(pubTag2);
            pub.setPubTags(pubTags);

            pub.setPublishTime(new Date());

            pub.setEventTime(new Date());

            pub.setLocation("上海市");

            pubs.add(pub);
        }

        return pubs;
    }

    /**
     * 删除
     */
    @Test
    public void delete_public() throws Exception {
        test("/delete_public", "public_id", "1");
    }

    /**
     * 获取
     */
    @Test
    public void get_public_order_by_time() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/get_public_order_by_time"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    /**
     * 发布评论
     */
    @Test
    public void publish_comment() throws Exception {
        int n = 10;
        List<Comment> comments = create_comment(n);
        for (int i = 0; i < comments.size(); i++)
            test("/publish_comment", "comment", JSON.toJSONString(comments.get(i)));
    }

    private List<Comment> create_comment(int n) {
        List<Comment> comments = new ArrayList<>();

        Random random = new Random();

        Pub pub = pubRepository.findPubByPublicId(1);
        for (int i = 0; i < n; i++) {
            Comment comment = new Comment();

            comment.setUser(userController.view_information(random.nextInt(10) + 7));

            comment.setPub(pub);

            comment.setContent("test comment");

            comment.setTime(new Date());

            comments.add(comment);
        }

        return comments;
    }

    /**
     * 删除评论
     */
    @Test
    public void delete_comment() throws Exception {
        test("/delete_comment", "comment_id", "1");
    }

    /**
     * 加入
     */
    @Test
    public void join() throws Exception {
        for (int i = 0; i < 10; i++) {
            Joining joining = new Joining();
            joining.setUser(userController.view_information(7 + i));
            joining.setPub(pubRepository.findPubByPublicId(1));
            test("/join", "joining", JSON.toJSONString(joining));
        }
    }

    /**
     * 取消加入
     */
    @Test
    public void not_join() throws Exception {
        test("/not_join", "joining_id", "1");
    }

    /**
     * 收藏
     */
    @Test
    public void collect() throws Exception {
        for (int i = 0; i < 10; i++) {
            Collection collection = new Collection();
            collection.setUser(userController.view_information(7 + i));
            collection.setPub(pubRepository.findPubByPublicId(1));
            test("/collect", "collection", JSON.toJSONString(collection));
        }
    }

    /**
     * 取消收藏
     */
    @Test
    public void not_collect() throws Exception {
        test("/not_collect", "collection_id", "1");
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
