package org.xperience.iteration2.domain.entities.cleaning;

import org.xperience.iteration2.domain.ForSettingSystemDateTime;
import org.xperience.iteration2.domain.RobotState;
import org.xperience.iteration2.domain.entities.logging.ForLoggingActivities;
import org.xperience.iteration2.domain.entities.logging.LogEvent;
import org.xperience.iteration2.domain.entities.map.SpaceMap;
import org.xperience.iteration2.domain.helpers.PartOfTheDay;


public class Robot {
    ForSettingSystemDateTime systemDateTime;
    RobotState currentState;
    ForLoggingActivities activityLogger;

    public Robot(ForSettingSystemDateTime systemDateTime, ForLoggingActivities logger) {
        this.systemDateTime = systemDateTime;
        this.activityLogger= logger;
    }

    public String start() {
        setCurrentState(RobotState.ON);
        activityLogger.log(LogEvent.START, "Robot started");
        return String.format("%s %s", "Good", PartOfTheDay.get(systemDateTime.get().getHour()));

    }

    private void setCurrentState(RobotState newState) {
        this.currentState = newState;
    }

    public void clean(SpaceMap spaceMap, CleaningMode cleaningMode) {
        this.setCurrentState(RobotState.CLEANING);
        activityLogger.log(LogEvent.CLEAN, "Robot cleaning");
        cleaningMode.execute(spaceMap);
    }


    public RobotState getCurrentState() {
        return currentState;
    }
}
