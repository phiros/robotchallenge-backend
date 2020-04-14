package com.github.phiros.robotchallenge.backend.web.model;

import com.github.phiros.robotchallenge.backend.domain.RobotPosition;

import java.util.List;
import java.util.Objects;
import java.util.Vector;

public class Grid {
    private List<GridRow> rows;

    public Grid(int width, int height, RobotPosition robotPosition) {
        this.rows = new Vector<>();

        for (int row = 0; row < height; row++) {
            var currentRow = new GridRow();
            for (int column = 0; column < width; column++) {
                if (robotPosition.getX() == column && robotPosition.getY() == row) {
                    String heading = robotPosition.getHeading().toString().toLowerCase();
                    currentRow.addCell(new GridCell(heading));
                } else {
                    currentRow.addCell(new GridCell());
                }
            }
            this.rows.add(currentRow);
        }
    }

    public GridCell gridCell(int x, int y) {
        return row(y).cell(x);
    }

    public GridRow row(int y) {
        return rows().get(y);
    }

    public List<GridRow> rows() {
        return this.rows;
    }

    public static class GridRow {
        private List<GridCell> cells;

        public GridRow() {
            this.cells = new Vector<>();
        }

        public void addCell(GridCell gridCell) {
            cells.add(gridCell);
        }

        public GridCell cell(int x) {
            return cells().get(x);
        }

        public List<GridCell> cells() {
            return this.cells;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GridRow gridRow = (GridRow) o;
            return Objects.equals(cells, gridRow.cells);
        }

        @Override
        public int hashCode() {
            return Objects.hash(cells);
        }

        @Override
        public String toString() {
            return "GridRow{" +
                    "cells=" + cells +
                    '}';
        }
    }

    public static class GridCell {
        private boolean robotPresent;
        private String heading;

        public GridCell(String heading) {
            this.robotPresent = true;
            this.heading = heading;
        }

        public GridCell() {
            this.robotPresent = false;
            this.heading = "";
        }

        public boolean isRobotPresent() {
            return robotPresent;
        }

        public String getHeading() {
            return heading;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GridCell gridCell = (GridCell) o;
            return isRobotPresent() == gridCell.isRobotPresent() &&
                    Objects.equals(getHeading(), gridCell.getHeading());
        }

        @Override
        public int hashCode() {
            return Objects.hash(isRobotPresent(), getHeading());
        }

        @Override
        public String toString() {
            return "GridCell{" +
                    "robotPresent=" + robotPresent +
                    ", heading='" + heading + '\'' +
                    '}';
        }
    }
}
