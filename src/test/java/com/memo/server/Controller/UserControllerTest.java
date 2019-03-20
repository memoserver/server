package com.memo.server.Controller;

import com.alibaba.fastjson.JSON;
import com.memo.server.controller.UserController;
import com.memo.server.entity.user.Follow;
import com.memo.server.entity.user.Tag;
import com.memo.server.entity.user.UserBase;
import com.memo.server.entity.user.UserSelf;
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

import java.sql.Date;
import java.util.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private UserController userController;

    //初始化执行
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    /**
     * 验证register
     *
     * @throws Exception
     */

    // 注册成功
    @Test
    public void register_success() throws Exception {
        int n = 10;

        List<UserSelf> userSelves = create_user(n);

        for (int i = 0; i < n; i++) {
            String account = userSelves.get(i).getAccount();
            String password = userSelves.get(i).getPassword();
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/register")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .param("account", account)
                    .param("password", password)
            )
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
            System.out.println(result.getResponse().getContentAsString());
        }

    }

    private List<UserSelf> create_user(int n) {
        List<UserSelf> userSelves = new ArrayList<>();

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
            String account = "";
            String password = "";
            for (int j = 0; j < 10; j++) {
                account = account + alpha[random.nextInt(62)];
                password = password + alpha[random.nextInt(62)];
            }

            userSelves.add(new UserSelf(account, password, 0));
        }

        return userSelves;
    }

    // 注册_用户已存在
    @Test
    public void register_user_exist() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/register")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("account", "abcdefg")
                .param("password", "123456")
        )
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    /**
     * login
     *
     * @throws Exception
     */

    @Test
    // 登录成功
    public void login_succes() throws  Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("account", "test")
                .param("password","123456")
        )
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    // 登录_用户名不存在
    public void login_user_not_exist() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("account", "test1")
                .param("password", "1234567")
        )
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    // 登录_密码错误
    public void login_password_fail() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("account", "test")
                .param("password", "1234567")
        )
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    /**
     * 信息完善
     */
    @Test
    public void modify_information() throws Exception {
        UserBase user = new UserBase();
        user.setUserId(6);
        user.setAccount("test");
        user.setPhoto("abc");
        user.setName("李四");
        user.setGender(false);
        user.setBirth(Date.valueOf("2000-5-6"));
        user.setPhone("1878945875");
        user.setDescription("喜欢读书");
        user.setJob("程序员");
        user.setAddress("上海市普陀区");

        Set<Tag> tags = new HashSet<>();
        Tag tag1 = new Tag();
        tag1.setTag("看书");
        tag1.setUserId(6);
        tags.add(tag1);
        Tag tag2 = new Tag();
        tag2.setUserId(6);
        tag2.setTag("看电影");
        tags.add(tag2);
        user.setTags(tags);

        String jsonUser = JSON.toJSONString(user);
        test("/modify_information", "user", jsonUser);
    }

    /**
     * tag
     */
    // 添加
    @Test
    public void add_tag() throws Exception {
        Tag tag = new Tag();
        tag.setUserId(6);
        tag.setTag("听音乐");

        String jsonTag = JSON.toJSONString(tag);
        test("/add_tag", "tag", jsonTag);
    }

    // 删除
    @Test
    public void delete_tag() throws Exception {
        Tag tag = new Tag();
        tag.setUserId(6);
        tag.setTag("听音乐");

        String jsonTag = JSON.toJSONString(tag);
        test("/delete_tag", "tag", jsonTag);
    }

    /**
     * follow
     */
    //添加
    @Test
    public void add_following() throws Exception {
        int n = 10;
        List<Follow> follows = create_follow(n);

        for (int i = 0; i < follows.size(); i++)
            test("/add_following", "follow", JSON.toJSONString(follows.get(i)));
    }

    private List<Follow> create_follow(int n) {
        List<Follow> follows = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int following = 6 + random.nextInt(11);
            int follwed = 6 + random.nextInt(11);
            if (following != follwed) {
                follows.add(new Follow(following, follwed));
            }
        }

        return follows;
    }

    // 删除
    @Test
    public void delete_following() throws Exception {
        Follow follow = new Follow(9, 8);
        test("/delete_following", "follow", JSON.toJSONString(follow));
    }

    /**
     * 查看用户信息
     */
    @Test
    public void view_information() throws Exception {
        test("/view_information", "user_id", "9");
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
