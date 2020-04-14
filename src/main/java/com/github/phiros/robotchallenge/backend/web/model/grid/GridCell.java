package com.github.phiros.robotchallenge.backend.web.model.grid;

import com.github.phiros.robotchallenge.backend.domain.RobotPosition;

import java.util.Objects;

public class GridCell {
    private boolean robotPresent;
    private String robotHeading;

    private GridCell() {
        this.robotPresent = false;
        this.robotHeading = "";
    }

    public static GridCell emptyCell() {
        return new GridCell();
    }

    public boolean isRobotPresent() {
        return robotPresent;
    }

    public String getRobotHeading() {
        return robotHeading;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridCell gridCell = (GridCell) o;
        return isRobotPresent() == gridCell.isRobotPresent() &&
                Objects.equals(getRobotHeading(), gridCell.getRobotHeading());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isRobotPresent(), getRobotHeading());
    }

    @Override
    public String toString() {
        return "GridCell{" +
                "robotPresent=" + robotPresent +
                ", heading='" + robotHeading + '\'' +
                '}';
    }

    public void placeRobot(RobotPosition robotPosition) {
        this.robotPresent = true;
        this.robotHeading = robotPosition.getHeading().toString().toLowerCase();
    }
}
