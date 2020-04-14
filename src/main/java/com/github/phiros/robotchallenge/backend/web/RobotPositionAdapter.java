package com.github.phiros.robotchallenge.backend.web;

import com.github.phiros.robotchallenge.backend.domain.RobotPosition;
import com.github.phiros.robotchallenge.backend.domain.RobotPositionCalculator;
import org.springframework.stereotype.Component;

@Component
public class RobotPositionAdapter {
    private RobotScriptParser robotScriptParser;
    private RobotPositionCalculator robotPositionCalculator;

    public RobotPositionAdapter() {
        robotScriptParser = new RobotScriptParser();
        robotPositionCalculator = new RobotPositionCalculator(5, 5);
    }

    public RobotPositionAdapter(RobotScriptParser robotScriptParser, RobotPositionCalculator robotPositionCalculator) {
        this.robotScriptParser = robotScriptParser;
        this.robotPositionCalculator = robotPositionCalculator;
    }

    public RobotPosition calculateRobotPosition(String script) {
        var movementInstructions = robotScriptParser.parse(script);
        return robotPositionCalculator.execute(movementInstructions);
    }
}
