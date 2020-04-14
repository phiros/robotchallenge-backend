package com.github.phiros.robotchallenge.backend.web.model.grid;

import java.util.List;
import java.util.Objects;
import java.util.Vector;

public class GridRow {
    private List<GridCell> cells;

    public GridRow(List<GridCell> cells) {
        this.cells = cells;
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
