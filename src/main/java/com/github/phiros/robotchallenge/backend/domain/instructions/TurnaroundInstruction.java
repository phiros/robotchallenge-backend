package com.github.phiros.robotchallenge.backend.domain.instructions;

public class TurnaroundInstruction implements RobotMovementInstruction {
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        return obj != null && getClass() == obj.getClass();
    }

    @Override
    public int hashCode() {
        return 44;
    }

    @Override
    public String toString() {
        return "TurnaroundInstruction{}";
    }
}
