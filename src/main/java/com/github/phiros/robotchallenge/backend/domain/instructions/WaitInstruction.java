package com.github.phiros.robotchallenge.backend.domain.instructions;

public class WaitInstruction implements RobotMovementInstruction {
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        return obj != null && getClass() == obj.getClass();
    }

    @Override
    public int hashCode() {
        return 43;
    }

    @Override
    public String toString() {
        return "WaitInstruction{}";
    }
}
