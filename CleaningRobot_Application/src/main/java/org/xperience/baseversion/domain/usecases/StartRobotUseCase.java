package org.xperience.baseversion.domain.usecases;


import org.xperience.baseversion.domain.entities.Robot;

public class StartRobotUseCase {
    Robot robot;

    public StartRobotUseCase() {
        robot = new Robot();
    }

    public String start() {
        return robot.start();
    }
}
