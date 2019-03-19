package com.memo.server.Controller;

import com.memo.server.service.memo.pub.PubRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublicControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private PubRepository pubRepository;
}
