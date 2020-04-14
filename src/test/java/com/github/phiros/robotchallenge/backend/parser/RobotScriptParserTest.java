package com.github.phiros.robotchallenge.backend.parser;

import com.github.phiros.robotchallenge.backend.domain.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RobotScriptParserTest {

    @Test
    public void testEmptyScriptShouldResultInEmptyInstructionList() {
        var parser = new RobotScriptParser();
        var instructions = parser.parse("");

        assertThat(instructions).hasSize(0);
    }

    @Test
    public void testShouldParsePredefinedScript() {
        var predefinedScript = String.join(System.getProperty("line.separator"),
                "POSITION 1 3 EAST //sets the initial position for the robot",
                "FORWARD 3 //lets the robot do 3 steps forward",
                "WAIT //lets the robot do nothing",
                "TURNAROUND //lets the robot turn around",
                "FORWARD 1 //lets the robot do 1 step forward",
                "RIGHT //lets the robot turn right",
                "FORWARD 2 //lets the robot do 2 steps forward"
        );
        var parser = new RobotScriptParser();

        var instructions = parser.parse(predefinedScript);

        assertThat(instructions).isEqualTo(
                List.of(new PositionInstruction(1, 3, RobotHeading.East),
                        new ForwardInstruction(3),
                        new WaitInstruction(),
                        new TurnaroundInstruction(),
                        new ForwardInstruction(1),
                        new RightInstruction(),
                        new ForwardInstruction(2)
                )
        );
    }

    @Test
    public void testLinesWhichCannotBeParsedAreTranslatedToWaitInstructions() {
        var predefinedScript = String.join(System.getProperty("line.separator"),
                "POSITION 1 3 EAST //sets the initial position for the robot",
                "FORWARD 3 //lets the robot do 3 steps forward",
                "DEADBEEF //lets the robot do nothing",
                "TURNAROUND //lets the robot turn around",
                "FORWARD 1 //lets the robot do 1 step forward",
                "FOOBAR //lets the robot turn right",
                "FORWARD 2 //lets the robot do 2 steps forward"
        );
        var parser = new RobotScriptParser();

        var instructions = parser.parse(predefinedScript);

        assertThat(instructions).isEqualTo(
                List.of(new PositionInstruction(1, 3, RobotHeading.East),
                        new ForwardInstruction(3),
                        new WaitInstruction(),
                        new TurnaroundInstruction(),
                        new ForwardInstruction(1),
                        new WaitInstruction(),
                        new ForwardInstruction(2)
                )
        );
    }

    @Test
    public void testPositionInstructionShouldSupportAllHeadings() {
        var predefinedScript = String.join(System.getProperty("line.separator"),
                "POSITION 1 3 NORTH",
                "POSITION 1 3 EAST",
                "POSITION 1 3 SOUTH",
                "POSITION 1 3 WEST"

        );
        var parser = new RobotScriptParser();

        var instructions = parser.parse(predefinedScript);

        assertThat(instructions).isEqualTo(
                List.of(new PositionInstruction(1, 3, RobotHeading.North),
                        new PositionInstruction(1, 3, RobotHeading.East),
                        new PositionInstruction(1, 3, RobotHeading.South),
                        new PositionInstruction(1, 3, RobotHeading.West)
                )
        );
    }
}
