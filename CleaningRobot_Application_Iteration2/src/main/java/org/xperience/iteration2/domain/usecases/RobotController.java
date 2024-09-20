package org.xperience.iteration2.domain.usecases;

import lombok.Builder;
import org.xperience.iteration2.domain.entities.cleaning.CleaningMode;
import org.xperience.iteration2.ports.ForFetchingSpaceMap;
import org.xperience.iteration2.domain.entities.map.ObstacleSensorSystem;
import org.xperience.iteration2.domain.entities.cleaning.Robot;
import org.xperience.iteration2.domain.entities.map.SpaceMap;

@Builder
public class RobotController {
    Robot robot;
    ForFetchingSpaceMap mapProvider;
    ObstacleSensorSystem obstacleSensorSystem;

    public String start() {
        return robot.start();
    }

    public void clean(String spaceId, CleaningMode cleaningMode) {
        SpaceMap spaceMap = mapProvider.fetch(spaceId);
        robot.clean(spaceMap, cleaningMode);
    }

}
