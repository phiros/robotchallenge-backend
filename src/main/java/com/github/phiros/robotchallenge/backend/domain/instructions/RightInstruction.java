package com.github.phiros.robotchallenge.backend.domain.instructions;

import com.github.phiros.robotchallenge.backend.domain.RobotHeading;
import com.github.phiros.robotchallenge.backend.domain.RobotPosition;

public class RightInstruction implements RobotMovementInstruction {
    @Override
    public RobotPosition execute(RobotPosition before) {
        var x = before.getX();
        var y = before.getY();
        var heading = before.getHeading();

        switch (heading) {
            case North:
                return new RobotPosition(x, y, RobotHeading.East);
            case East:
                return new RobotPosition(x, y, RobotHeading.South);
            case South:
                return new RobotPosition(x, y, RobotHeading.West);
            case West:
                return new RobotPosition(x, y, RobotHeading.North);
        }
        return before;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        return obj != null && getClass() == obj.getClass();
    }

    @Override
    public int hashCode() {
        return 42;
    }


    @Override
    public String toString() {
        return "RightInstruction{}";
    }
}
