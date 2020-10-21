package com.hry.mock.control;

import com.hry.mock.MockApplication;
import org.junit.Assert;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2020/10/21 18:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockApplication.class)
public class MockMvcTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    //在每个测试方法执行之前都初始化MockMvc对象
    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * 查询一个不存在到url
     *
     * @throws Exception
     */
    @Test
    public void mockNotExistUrl() throws Exception {
        //perform,执行一个RequestBuilders请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理
        mockMvc.perform(
                MockMvcRequestBuilders
                //构造一个get请求
                .get("/user/1")
                //请求类型 json
                .contentType(MediaType.APPLICATION_JSON))
                // 期待返回的状态码是4XX，因为我们并没有写/user/{id}的get接口
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * 查询一个get请求的结果
     * @throws Exception
     */
    @Test
    public void mockGet() throws Exception {
        //perform,执行一个RequestBuilders请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理
        mockMvc.perform(
                MockMvcRequestBuilders
                //构造一个get请求
                .get("/mock/queryById")
                // 传入参数
                .param("id","1234")
                //请求类型 json
                .contentType(MediaType.APPLICATION_JSON))
                // 期望的结果状态 200
                .andExpect(MockMvcResultMatchers.status().isOk())
                //添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * 测试一个post请求
     * @throws Exception
     */
    @Test
    public void mockPost() throws Exception {
        String jsonResult = "{\"id\":\"1234\"}";
        // perform : 执行请求 ;
        mockMvc.perform(MockMvcRequestBuilders
                .post("/mock/add")
                .accept(MediaType.APPLICATION_JSON)
                //传参,因为后端是@RequestBody所以这里直接传json字符串
                .content(jsonResult)
                // 请求type : json
                .contentType(MediaType.APPLICATION_JSON))
                // 期望的结果状态 200
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * 模拟请求，对返回业务数据进行判断
     *
     * @throws Exception
     */
    @Test
    public void mockResult() throws Exception {

        // perform : 执行请求 ;
        mockMvc.perform(MockMvcRequestBuilders
                .get("/mock/query")
                // 请求type : json
                .contentType(MediaType.APPLICATION_JSON))
                // 期望的结果状态 200
                .andExpect(MockMvcResultMatchers.status().isOk())
                //期望返回的结果集合有1个元素
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1))
                //添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                .andDo(MockMvcResultHandlers.print());

    }


    /**
     * 模拟请求，对请求的结果 MvcResult 进行判断
     *
     * @throws Exception
     */
    @Test
    public void mockMvcResult() throws Exception {
        String jsonResult = "{\"id\":\"1234\"}";
        // perform : 执行请求 ;
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/mock/add")
                .accept(MediaType.APPLICATION_JSON)
                //传参,因为后端是@RequestBody所以这里直接传json字符串
                .content(jsonResult)
                // 请求type : json
                .contentType(MediaType.APPLICATION_JSON))
                // 期望的结果状态 200
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
                .andReturn();//返回结果

        // 对返回结果进行判断
        int statusCode = mvcResult.getResponse().getStatus();
        String result = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(200, statusCode);
        Assert.assertEquals("1", result);
    }




}
