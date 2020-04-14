package com.github.phiros.robotchallenge.backend.parser;

import com.github.phiros.robotchallenge.backend.domain.RobotHeading;
import com.github.phiros.robotchallenge.backend.domain.instructions.*;

import java.util.List;
import java.util.stream.Collectors;

public class RobotScriptParser {
    public List<RobotMovementInstruction> parse(String instructions) {
        return instructions.lines()
                .filter(line -> !line.isBlank())
                .map(this::parseLine)
                .collect(Collectors.toList());
    }

    private RobotMovementInstruction parseLine(String line) {
        var tokens = line.split(" ");
        var instruction = tokens[0];
        switch (instruction) {
            case "POSITION":
                return parsePosition(tokens);
            case "FORWARD":
                return parseForward(tokens);
            case "WAIT":
                return new WaitInstruction();
            case "TURNAROUND":
                return new TurnaroundInstruction();
            case "RIGHT":
                return new RightInstruction();
        }
        return new WaitInstruction();
    }

    private RobotMovementInstruction parseForward(String[] tokens) {
        var gridSteps = Integer.parseInt(tokens[1]);
        return new ForwardInstruction(gridSteps);
    }

    private RobotMovementInstruction parsePosition(String[] tokens) {
        var x = Integer.parseInt(tokens[1]);
        var y = Integer.parseInt(tokens[2]);
        var heading = parseHeading(tokens[3]);
        return new PositionInstruction(x, y, heading);
    }

    private RobotHeading parseHeading(String heading) {
        switch (heading) {
            case "NORTH":
                return RobotHeading.North;
            case "EAST":
                return RobotHeading.East;
            case "SOUTH":
                return RobotHeading.South;
            case "WEST":
                return RobotHeading.West;
        }
        return RobotHeading.East;
    }
}
