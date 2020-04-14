package com.github.phiros.robotchallenge.backend.domain;

import com.github.phiros.robotchallenge.backend.domain.instructions.RobotMovementInstruction;

import java.util.List;

public class RobotPositionCalculator {
    private int width;
    private int height;
    private int maxX;
    private int maxY;

    public RobotPositionCalculator(int width, int height) {
        this.width = width;
        this.height = height;
        this.maxX = width - 1;
        this.maxY = height - 1;
    }

    public RobotPosition execute(List<RobotMovementInstruction> movementInstructions) {
        RobotPosition position = RobotPosition.DEFAULT_POSITION;
        for (RobotMovementInstruction instruction : movementInstructions) {
            position = instruction.execute(position);
            position = correctForGridBoundaries(position);
        }
        return position;
    }

    private RobotPosition correctForGridBoundaries(RobotPosition position) {
        var x = pushIntoInterval(position.getX(), maxX);
        var y = pushIntoInterval(position.getY(), maxY);
        return new RobotPosition(x, y, position.getHeading());
    }

    private int pushIntoInterval(int number, int upperInclusive) {
        if (number > upperInclusive) return upperInclusive;
        return Math.max(number, 0);
    }
}
