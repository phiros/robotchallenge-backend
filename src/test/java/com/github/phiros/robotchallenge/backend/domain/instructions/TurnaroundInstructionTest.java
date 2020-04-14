package com.github.phiros.robotchallenge.backend.domain.instructions;

import com.github.phiros.robotchallenge.backend.domain.RobotHeading;
import com.github.phiros.robotchallenge.backend.domain.RobotPosition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TurnaroundInstructionTest {

    @Test
    public void testTurnsRobot180degrees() {
        var north = new RobotPosition(1, 1, RobotHeading.North);
        var east = new RobotPosition(1, 1, RobotHeading.East);
        var south = new RobotPosition(1, 1, RobotHeading.South);
        var west = new RobotPosition(1, 1, RobotHeading.West);

        var turnaroundInstruction = new TurnaroundInstruction();

        assertThat(turnaroundInstruction.execute(north)).isEqualTo(south);
        assertThat(turnaroundInstruction.execute(east)).isEqualTo(west);
        assertThat(turnaroundInstruction.execute(south)).isEqualTo(north);
        assertThat(turnaroundInstruction.execute(west)).isEqualTo(east);
    }
}
