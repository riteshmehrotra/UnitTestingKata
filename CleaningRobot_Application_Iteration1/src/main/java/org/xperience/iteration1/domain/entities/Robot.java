package org.xperience.iteration1.domain.entities;

import org.xperience.iteration1.domain.ForSettingSystemDateTime;
import org.xperience.iteration1.domain.helpers.PartOfTheDay;


public class Robot {
    ForSettingSystemDateTime systemDateTime;
    public Robot(ForSettingSystemDateTime systemDateTime) {
        this.systemDateTime = systemDateTime;
    }

    public String start() {
        return String.format("%s %s", "Good", PartOfTheDay.get(systemDateTime.get().getHour()));
    }

}
