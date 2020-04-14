package com.github.phiros.robotchallenge.backend.domain.instructions;

import com.github.phiros.robotchallenge.backend.domain.RobotHeading;
import com.github.phiros.robotchallenge.backend.domain.RobotPosition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ForwardInstructionTest {

    @Test
    public void testMovesRobotInHeadingDirection() {
        var north = new RobotPosition(1, 1, RobotHeading.North);
        var east = new RobotPosition(1, 1, RobotHeading.East);
        var south = new RobotPosition(1, 1, RobotHeading.South);
        var west = new RobotPosition(1, 1, RobotHeading.West);

        var forward = new ForwardInstruction(1);

        assertThat(forward.execute(north)).isEqualTo(new RobotPosition(1, 0, RobotHeading.North));
        assertThat(forward.execute(east)).isEqualTo(new RobotPosition(2, 1, RobotHeading.East));
        assertThat(forward.execute(south)).isEqualTo(new RobotPosition(1, 2, RobotHeading.South));
        assertThat(forward.execute(west)).isEqualTo(new RobotPosition(0, 1, RobotHeading.West));
    }
}
