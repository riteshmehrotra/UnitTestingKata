package org.xperience.iteration1.domain.usecases;

import org.xperience.iteration1.domain.entities.Robot;

public class RobotController {
    Robot robot;

    public RobotController(Robot robot) {
        this.robot = robot;
    }

    public String start() {
        return robot.start();
    }

}
