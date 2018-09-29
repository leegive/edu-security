package io.github.leegive;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * TODO
 *
 * @author leegive
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testQuerySuccess() throws Exception {
        mvc.perform(get("/user")
            .contentType(APPLICATION_JSON_UTF8)
            .param("username", "edu")
            .param("age", "18")
            .param("ageTO", "50")
            .param("xxx", "yyy")
            .param("size", "15")
            .param("page", "3")
            .param("sort", "age,desc")
        )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(3)
        );
    }

}
