package com.github.phiros.robotchallenge.backend.domain.instructions;

import java.util.Objects;

public class ForwardInstruction implements RobotMovementInstruction {
    private int gridSteps;

    public ForwardInstruction(int gridSteps) {
        this.gridSteps = gridSteps;
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
