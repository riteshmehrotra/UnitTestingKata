package org.xperience.iteration2.domain.testdoubles;

import org.xperience.iteration2.domain.entities.map.SpaceMap;
import org.xperience.iteration2.ports.ForFetchingSpaceMap;

public class StubbedMapProvider implements ForFetchingSpaceMap {
    @Override
    public SpaceMap fetch(String spaceId) {
        return new SpaceMap(10, 10);
    }
}
