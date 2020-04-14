package com.github.phiros.robotchallenge.backend.services;

import com.github.phiros.robotchallenge.backend.domain.RobotPosition;
import com.github.phiros.robotchallenge.backend.domain.RobotPositionCalculator;
import com.github.phiros.robotchallenge.backend.parser.RobotScriptParser;
import org.springframework.stereotype.Service;

@Service
public class RobotPositionService {
    private RobotScriptParser robotScriptParser;
    private RobotPositionCalculator robotPositionCalculator;

    public RobotPositionService() {
        robotScriptParser = new RobotScriptParser();
        robotPositionCalculator = new RobotPositionCalculator(5, 5);
    }

    public RobotPositionService(RobotScriptParser robotScriptParser, RobotPositionCalculator robotPositionCalculator) {
        this.robotScriptParser = robotScriptParser;
        this.robotPositionCalculator = robotPositionCalculator;
    }

    public RobotPosition calculateRobotPosition(String script) {
        var movementInstructions = robotScriptParser.parse(script);
        return robotPositionCalculator.execute(movementInstructions);
    }
}
