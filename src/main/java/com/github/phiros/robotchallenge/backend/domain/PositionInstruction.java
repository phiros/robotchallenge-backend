package com.github.phiros.robotchallenge.backend.domain;

import java.util.Objects;

public class PositionInstruction implements RobotMovementInstruction {
    private int x;
    private int y;
    private RobotHeading heading;

    public PositionInstruction(int x, int y, RobotHeading heading) {
        this.x = x;
        this.y = y;
        this.heading = heading;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionInstruction that = (PositionInstruction) o;
        return x == that.x &&
                y == that.y &&
                heading == that.heading;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, heading);
    }

    @Override
    public String toString() {
        return "PositionInstruction{" +
                "x=" + x +
                ", y=" + y +
                ", heading=" + heading +
                '}';
    }
}
