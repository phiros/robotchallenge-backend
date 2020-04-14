package com.github.phiros.robotchallenge.backend.web.model.grid;

import com.github.phiros.robotchallenge.backend.domain.RobotHeading;
import com.github.phiros.robotchallenge.backend.domain.RobotPosition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GridTest {

    @Test
    public void testGridDimensionsShouldCorrespondToGivenDimensions() {
        var twoByTwo = new Grid(2, 2, RobotPosition.DEFAULT_POSITION);
        var threeByThree = new Grid(3, 3, RobotPosition.DEFAULT_POSITION);
        var fiveByFive = new Grid(5, 5, RobotPosition.DEFAULT_POSITION);

        assertThat(twoByTwo.rows()).hasSize(2);
        assertThat(twoByTwo.rows().get(1).cells()).hasSize(2);
        assertThat(threeByThree.rows()).hasSize(3);
        assertThat(threeByThree.rows().get(2).cells()).hasSize(3);
        assertThat(fiveByFive.rows()).hasSize(5);
        assertThat(fiveByFive.rows().get(4).cells()).hasSize(5);
    }

    @Test
    public void testRobotPositionInGridShouldCorrespondToGivenPosition() {
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                var grid = new Grid(5, 5, new RobotPosition(x, y, RobotHeading.East));
                assertThat(grid.gridCell(x, y).isRobotPresent()).isTrue();
                assertThat(grid.gridCell(x, y).getRobotHeading()).isEqualTo("east");
            }
        }
    }

    @Test
    public void testHeadingShouldBeTranslatedToLowerCase() {
        var north = new RobotPosition(1, 1, RobotHeading.North);
        var east = new RobotPosition(1, 1, RobotHeading.East);
        var south = new RobotPosition(1, 1, RobotHeading.South);
        var west = new RobotPosition(1, 1, RobotHeading.West);

        var gridNorthPosition = new Grid(5, 5, north);
        var gridEastPosition = new Grid(5, 5, east);
        var gridSouthPosition = new Grid(5, 5, south);
        var gridWestPosition = new Grid(5, 5, west);

        assertThat(gridNorthPosition.gridCell(1, 1).getRobotHeading()).isEqualTo("north");
        assertThat(gridEastPosition.gridCell(1, 1).getRobotHeading()).isEqualTo("east");
        assertThat(gridSouthPosition.gridCell(1, 1).getRobotHeading()).isEqualTo("south");
        assertThat(gridWestPosition.gridCell(1, 1).getRobotHeading()).isEqualTo("west");

    }
}
