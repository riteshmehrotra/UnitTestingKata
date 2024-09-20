package org.xperience.iteration2.domain.entities.map;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class SpaceMap {
    private final int width;
    private final int height;
    //May contain obstacles and coordinates

    public SpaceMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

}
