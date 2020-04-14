package com.github.phiros.robotchallenge.backend.domain;

import com.github.phiros.robotchallenge.backend.domain.instructions.RobotMovementInstruction;

import java.util.List;

public class RobotPositionCalculator {
    private int width;
    private int height;

    public RobotPositionCalculator(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public RobotPosition execute(List<RobotMovementInstruction> movementInstructions) {
        return null;
    }
}
