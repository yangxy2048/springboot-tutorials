package org.springboot.tutorials.controller;


import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springboot.tutorials.mapper.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;

/**
 * <p>
 *  用户测试类
 * </p>
 *
 * @author DevinYang
 * @version 1.0.0
 * @createTime 2020-03-22
 */
@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    UserController userController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenPostRequestToUsersAndValidUser_thenCorrectResponse() throws Exception {
        MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
        String user = "{\"name\": \"bob\", \"email\" : \"bob@domain.com\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .content(user)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(textPlainUtf8));
    }

    @Test
    public void whenPostRequestToUsersAndInValidUser_thenCorrectResponse() throws Exception {
        String user = "{\"name\": \"\", \"email\" : \"bob@domain.com\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .content(user)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is("Name is mandatory")))
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8));
    }


}
