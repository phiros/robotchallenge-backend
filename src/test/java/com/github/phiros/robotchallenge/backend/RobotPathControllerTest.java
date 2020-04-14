package com.github.phiros.robotchallenge.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RobotPathController.class)
public class RobotPathControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRootRouteExists() throws Exception {
        var result = mockMvc.perform(
                get("/"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andReturn();
    }

    @Test
    public void testRootRouteDeliversSiteWithFormExists() throws Exception {
        var result = mockMvc.perform(
                get("/"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andReturn();

        assertThat(result.getResponse().getContentAsString()).contains("<form");
    }

    @Test
    public void testRobotPositionRouteAcceptsSubmittedScript() throws Exception {
        var predefinedScript = String.join(System.getProperty("line.separator"),
                "POSITION 1 3 EAST //sets the initial position for the robot",
                "FORWARD 3 //lets the robot do 3 steps forward",
                "WAIT //lets the robot do nothing",
                "TURNAROUND //lets the robot turn around",
                "FORWARD 1 //lets the robot do 1 step forward",
                "RIGHT //lets the robot turn right",
                "FORWARD 2 //lets the robot do 2 steps forward"
        );

        var result = mockMvc.perform(
                post("/robotposition")
                        .param("script", predefinedScript))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andReturn();
    }
}
