package com.github.phiros.robotchallenge.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RobotPathController {
    @GetMapping(path = "/")
    public String form() {
        return "form";
    }
}
