package com.github.phiros.robotchallenge.backend.web;

import com.github.phiros.robotchallenge.backend.domain.RobotPosition;
import com.github.phiros.robotchallenge.backend.services.RobotPositionService;
import com.github.phiros.robotchallenge.backend.web.model.grid.Grid;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RobotPathController.class)
public class RobotPathControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RobotPositionService robotPositionService;

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
    public void testScriptIsTranslatedInGridWhichContainsRobot() throws Exception {
        var predefinedScript = String.join(System.getProperty("line.separator"),
                "WAIT //lets the robot do nothing"
        );

        when(robotPositionService.calculateRobotPosition(eq(predefinedScript))).thenReturn(RobotPosition.DEFAULT_POSITION);
        Grid expectedGrid = new Grid(5, 5, RobotPosition.DEFAULT_POSITION);

        var result = mockMvc.perform(
                post("/robotposition")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("script", predefinedScript))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(model().attribute("gridRows", expectedGrid.rows()))
                .andReturn();

        verify(robotPositionService).calculateRobotPosition(predefinedScript);
        assertThat(expectedGrid.rows()).hasSize(5);
        assertThat(expectedGrid.gridCell(0, 0).isRobotPresent()).isTrue();
    }
}
