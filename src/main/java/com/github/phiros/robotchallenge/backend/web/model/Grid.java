package com.github.phiros.robotchallenge.backend.web.model;

import com.github.phiros.robotchallenge.backend.domain.RobotPosition;

import java.util.Collections;
import java.util.List;

public class Grid {
    private int width;
    private int height;
    private RobotPosition robotPosition;

    public Grid(int width, int height, RobotPosition robotPosition) {
        this.width = width;
        this.height = height;
        this.robotPosition = robotPosition;
    }

    public List<GridRows> rows() {
        return Collections.emptyList();
    }

    public class GridRows {
    }
}
