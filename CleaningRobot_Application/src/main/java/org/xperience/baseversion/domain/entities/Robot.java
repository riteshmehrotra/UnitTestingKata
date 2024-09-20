package org.xperience.baseversion.domain.entities;

import org.xperience.baseversion.domain.helpers.PartOfTheDay;

public class Robot {

    public String start() {
        return String.format("%s %s", "Good", PartOfTheDay.get());
    }

}
