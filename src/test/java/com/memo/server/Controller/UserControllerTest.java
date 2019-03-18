package com.memo.server.Controller;

import com.memo.server.controller.UserController;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserControllerTest {
    private MockMvc mockMvc;

    //初始化执行
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    //验证controller是否正常响应并打印返回结果
    @Test
    public void loginin() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("account", "abcdefg");
        map.put("password", "123456");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("account", "abcdefg")
                .param("password", "123456")
        )
                .andExpect(status().isOk())// 模拟向testRest发送get请求
                //.andDo(MockMvcResultHandlers.print())
                .andReturn();// 返回执行请求的结果

        System.out.println(result.getResponse().getContentAsString());
//        mvc.perform(MockMvcRequestBuilders.get("/register").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
    }

    //验证controller是否正常响应并判断返回结果是否正确
    @Ignore
    @Test
    public void testHello() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/register").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("Hello World")));
    }
}
