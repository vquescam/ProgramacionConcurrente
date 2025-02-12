package com.feedback1.monitoring;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(classes = MonitoringApplication.class)
@AutoConfigureMockMvc
public class SecurityControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSecureEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/secure")
                        .param("data", "testData")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Secured data: testData"));
    }
}