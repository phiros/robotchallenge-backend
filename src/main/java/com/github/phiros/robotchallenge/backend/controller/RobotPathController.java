package com.github.phiros.robotchallenge.backend.controller;

import com.github.phiros.robotchallenge.backend.services.RobotPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RobotPathController {
    @Autowired
    private RobotPositionService robotPositionService;

    @GetMapping(path = "/")
    public String form() {
        return "form";
    }

    @PostMapping(path = "/robotposition", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String robotPosition(FormData formData) {
        robotPositionService.calculateRobotPosition(formData.script);
        return "robotposition";
    }
}
