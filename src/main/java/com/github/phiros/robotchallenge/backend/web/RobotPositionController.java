package com.github.phiros.robotchallenge.backend.web;

import com.github.phiros.robotchallenge.backend.web.model.FormData;
import com.github.phiros.robotchallenge.backend.web.model.grid.Grid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RobotPositionController {
    @Autowired
    private RobotPositionAdapter robotPositionAdapter;

    @GetMapping(path = "/")
    public String form(Model model) {
        model.addAttribute("formData", new FormData());
        return "form";
    }

    @PostMapping(path = "/robotposition", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String robotPosition(FormData formData, Model model) {
        var position = robotPositionAdapter.calculateRobotPosition(formData.script);
        var grid = new Grid(5, 5, position);
        model.addAttribute("gridRows", grid.rows());
        return "robotposition";
    }
}
