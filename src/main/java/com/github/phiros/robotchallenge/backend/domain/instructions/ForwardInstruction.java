package com.github.phiros.robotchallenge.backend.domain.instructions;

import com.github.phiros.robotchallenge.backend.domain.RobotPosition;

import java.util.Objects;

public class ForwardInstruction implements RobotMovementInstruction {
    private int gridSteps;

    public ForwardInstruction(int gridSteps) {
        this.gridSteps = gridSteps;
    }

    @Override
    public RobotPosition execute(RobotPosition before) {
        var x = before.getX();
        var y = before.getY();
        var heading = before.getHeading();

        switch (heading) {
            case North:
                return new RobotPosition(x, y - gridSteps, heading);
            case East:
                return new RobotPosition(x + gridSteps, y, heading);
            case South:
                return new RobotPosition(x, y + gridSteps, heading);
            case West:
                return new RobotPosition(x - gridSteps, y, heading);
        }
        return before;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForwardInstruction that = (ForwardInstruction) o;
        return gridSteps == that.gridSteps;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gridSteps);
    }

    @Override
    public String toString() {
        return "ForwardInstruction{" +
                "gridSteps=" + gridSteps +
                '}';
    }
}
