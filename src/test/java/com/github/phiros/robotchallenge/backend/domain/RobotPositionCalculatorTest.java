package com.github.phiros.robotchallenge.backend.domain;

import com.github.phiros.robotchallenge.backend.domain.instructions.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RobotPositionCalculatorTest {

    @Test
    public void testEmptyInstructionsResultInDefaultPosition() {
        var calculator = new RobotPositionCalculator(5, 5);

        var position = calculator.execute(Collections.emptyList());

        assertThat(position).isEqualTo(RobotPosition.DEFAULT_POSITION);
    }

    @Test
    public void testPositionInstructionTeleportsRobot() {
        var calculator = new RobotPositionCalculator(5, 5);

        var position = calculator.execute(
                List.of(new PositionInstruction(1, 3, RobotHeading.East)
                ));

        assertThat(position).isEqualTo(new RobotPosition(1, 3, RobotHeading.East));
    }

    @Test
    public void testRobotPositionCalculatedCorrectForPredefinedScript() {
        var instructionsBasedOnScript = List.of(
                new PositionInstruction(1, 3, RobotHeading.East),
                new ForwardInstruction(3),
                new WaitInstruction(),
                new TurnaroundInstruction(),
                new ForwardInstruction(1),
                new RightInstruction(),
                new ForwardInstruction(2)
        );

        var expectedPositions = List.of(
                new RobotPosition(1, 3, RobotHeading.East),
                new RobotPosition(4, 3, RobotHeading.East),
                new RobotPosition(4, 3, RobotHeading.East),
                new RobotPosition(4, 3, RobotHeading.West),
                new RobotPosition(3, 3, RobotHeading.West),
                new RobotPosition(3, 3, RobotHeading.North),
                new RobotPosition(3, 1, RobotHeading.North)
        );

        var calculator = new RobotPositionCalculator(5, 5);

        for (int i = 0; i < instructionsBasedOnScript.size(); i++) {
            var instructions = instructionsBasedOnScript.subList(0, i + 1);
            var expectedResult = expectedPositions.get(i);
            assertThat(calculator.execute(instructions)).isEqualTo(expectedResult);
        }
    }
}
