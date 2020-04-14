package com.github.phiros.robotchallenge.backend.web.model.grid;

import com.github.phiros.robotchallenge.backend.domain.RobotPosition;

import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grid {
    private List<GridRow> rows;

    public Grid(int width, int height, RobotPosition robotPosition) {
        Supplier<List<GridCell>> rowContentSupplier = () -> Stream.generate(GridCell::emptyCell)
                .limit(width)
                .collect(Collectors.toList());
        this.rows = Stream.generate(rowContentSupplier)
                .limit(height)
                .map(GridRow::new)
                .collect(Collectors.toList());

        placeRobot(robotPosition);
    }

    private void placeRobot(RobotPosition robotPosition) {
        var x = robotPosition.getX();
        var y = robotPosition.getY();
        gridCell(x, y).placeRobot(robotPosition);
    }

    public GridCell gridCell(int x, int y) {
        return row(y).cell(x);
    }

    private GridRow row(int y) {
        return rows().get(y);
    }

    public List<GridRow> rows() {
        return this.rows;
    }

}
