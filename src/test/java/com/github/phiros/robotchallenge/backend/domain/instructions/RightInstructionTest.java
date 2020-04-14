package com.github.phiros.robotchallenge.backend.domain.instructions;

import com.github.phiros.robotchallenge.backend.domain.RobotHeading;
import com.github.phiros.robotchallenge.backend.domain.RobotPosition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RightInstructionTest {

    @Test
    public void testRightTurnsHeadingClockwise() {
        var north = new RobotPosition(1, 1, RobotHeading.North);
        var east = new RobotPosition(1, 1, RobotHeading.East);
        var south = new RobotPosition(1, 1, RobotHeading.South);
        var west = new RobotPosition(1, 1, RobotHeading.West);

        var rightInstruction = new RightInstruction();

        assertThat(rightInstruction.execute(north)).isEqualTo(east);
        assertThat(rightInstruction.execute(east)).isEqualTo(south);
        assertThat(rightInstruction.execute(south)).isEqualTo(west);
        assertThat(rightInstruction.execute(west)).isEqualTo(north);
    }
}
