package com.github.phiros.robotchallenge.backend.domain.instructions;

import com.github.phiros.robotchallenge.backend.domain.RobotHeading;
import com.github.phiros.robotchallenge.backend.domain.RobotPosition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionInstructionTest {

    @Test
    public void testShouldTeleportRobot() {
        var positionInstruction = new PositionInstruction(2, 1, RobotHeading.North);

        var newPosition = positionInstruction.execute(RobotPosition.DEFAULT_POSITION);

        assertThat(newPosition).isEqualTo(new RobotPosition(2, 1, RobotHeading.North));
    }
}
