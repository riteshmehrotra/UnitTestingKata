package org.xperience.iteration2.domain.helpers;

public class PartOfTheDay {
    public static String get(int hour) {
        if (hour < 12) {
            return "Morning";
        } else if (hour <= 17)
            return "Afternoon";
        else
            return "Evening";
    }
}
