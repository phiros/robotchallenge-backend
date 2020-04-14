package com.github.phiros.robotchallenge.backend.domain.instructions;

import com.github.phiros.robotchallenge.backend.domain.RobotHeading;
import com.github.phiros.robotchallenge.backend.domain.RobotPosition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WaitInstructionTest {

    @Test
    public void testWaitInstructionDoesNotChangeAnything() {
        var pos1 = new RobotPosition(1, 1, RobotHeading.North);
        var pos2 = new RobotPosition(1, 1, RobotHeading.East);
        var pos3 = new RobotPosition(1, 1, RobotHeading.South);
        var pos4 = new RobotPosition(1, 1, RobotHeading.West);

        var waitInstruction = new WaitInstruction();

        assertThat(waitInstruction.execute(pos1)).isEqualTo(pos1);
        assertThat(waitInstruction.execute(pos2)).isEqualTo(pos2);
        assertThat(waitInstruction.execute(pos3)).isEqualTo(pos3);
        assertThat(waitInstruction.execute(pos4)).isEqualTo(pos4);
    }
}
