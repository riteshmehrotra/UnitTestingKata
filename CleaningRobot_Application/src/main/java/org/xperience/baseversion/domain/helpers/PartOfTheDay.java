package org.xperience.baseversion.domain.helpers;

import java.time.LocalDateTime;

public class PartOfTheDay {
    public static String get() {
    LocalDateTime dateTimeNow = LocalDateTime.now();
    int hour = dateTimeNow.getHour();
        if (hour < 12) {
            return "Morning";
        } else if (hour <= 17)
            return "Afternoon";
        else
            return "Evening";
    }
}
