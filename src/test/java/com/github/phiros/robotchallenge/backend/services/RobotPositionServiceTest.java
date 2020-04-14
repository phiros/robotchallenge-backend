package com.github.phiros.robotchallenge.backend.services;

import com.github.phiros.robotchallenge.backend.domain.RobotPosition;
import com.github.phiros.robotchallenge.backend.domain.RobotPositionCalculator;
import com.github.phiros.robotchallenge.backend.domain.instructions.RobotMovementInstruction;
import com.github.phiros.robotchallenge.backend.domain.instructions.WaitInstruction;
import com.github.phiros.robotchallenge.backend.parser.RobotScriptParser;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RobotPositionServiceTest {

    @Test
    public void testServiceShouldParseAndCalculatePosition() {
        var predefinedScript = String.join(System.getProperty("line.separator"),
                "WAIT //lets the robot do nothing"
        );
        RobotScriptParser parser = Mockito.mock(RobotScriptParser.class);
        RobotPositionCalculator calculator = Mockito.mock(RobotPositionCalculator.class);
        RobotPositionService robotPositionService = new RobotPositionService(parser, calculator);
        List<RobotMovementInstruction> robotMovementInstructions = List.of(new WaitInstruction());
        when(parser.parse(eq(predefinedScript))).thenReturn(robotMovementInstructions);
        when(calculator.execute(eq(robotMovementInstructions))).thenReturn(RobotPosition.DEFAULT_POSITION);

        var robotPosition = robotPositionService.calculateRobotPosition(predefinedScript);

        verify(parser).parse(predefinedScript);
        verify(calculator).execute(robotMovementInstructions);
        assertThat(robotPosition).isEqualTo(RobotPosition.DEFAULT_POSITION);
    }
}
