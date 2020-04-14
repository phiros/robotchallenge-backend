package com.github.phiros.robotchallenge.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RobotPathController {
    @GetMapping(path = "/")
    public String form() {
        return "form";
    }

    @PostMapping(path = "/robotposition")
    public String robotPosition() {
        return "robotposition";
    }
}
