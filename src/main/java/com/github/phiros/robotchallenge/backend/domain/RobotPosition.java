package com.github.phiros.robotchallenge.backend.domain;

import java.util.Objects;

public class RobotPosition {
    private int x;
    private int y;
    private RobotHeading heading;

    public static final RobotPosition DEFAULT_POSITION = new RobotPosition(0, 0, RobotHeading.East);

    public RobotPosition(int x, int y, RobotHeading heading) {
        this.x = x;
        this.y = y;
        this.heading = heading;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public RobotHeading getHeading() {
        return heading;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RobotPosition that = (RobotPosition) o;
        return getX() == that.getX() &&
                getY() == that.getY() &&
                getHeading() == that.getHeading();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), getHeading());
    }

    @Override
    public String toString() {
        return "RobotPosition{" +
                "x=" + x +
                ", y=" + y +
                ", heading=" + heading +
                '}';
    }
}
