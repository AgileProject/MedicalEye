package cn.edu.seu.eye.web.test;


import cn.edu.seu.eye.module.base.utils.LoginUserUtil;
import cn.edu.seu.eye.web.AppConfig;
import cn.edu.seu.eye.web.MvcConfig;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.Cookie;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value =  "src/main/webapp")
@ContextHierarchy({
        @ContextConfiguration(name = "parent", classes = AppConfig.class),
        @ContextConfiguration(name = "child", classes = MvcConfig.class)
})
//@ContextConfiguration( classes = AppInitializer.class)
//src/main/webapp
public class BaseTestCase {
    @Autowired
    public WebApplicationContext wac;
    public MockMvc mockMvc;
    public Cookie mockCookie;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        mockCookie = new Cookie(LoginUserUtil.TOKEN, "test");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSayHello() throws Exception {
        Assert.assertEquals("a", "a");
    }
}
