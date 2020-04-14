package com.github.phiros.robotchallenge.backend.domain.instructions;

import com.github.phiros.robotchallenge.backend.domain.RobotPosition;

public interface RobotMovementInstruction {
    RobotPosition execute(RobotPosition before);
}
