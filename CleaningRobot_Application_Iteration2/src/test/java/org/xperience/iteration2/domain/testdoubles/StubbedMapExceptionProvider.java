package org.xperience.iteration2.domain.testdoubles;

import org.xperience.iteration2.domain.entities.map.SpaceMap;
import org.xperience.iteration2.domain.exceptions.SpaceMapNotFoundException;
import org.xperience.iteration2.ports.ForFetchingSpaceMap;

public class StubbedMapExceptionProvider implements ForFetchingSpaceMap {
    @Override
    public SpaceMap fetch(String spaceId) {
        throw new SpaceMapNotFoundException(String.format("Space map %s not found",spaceId));
    }
}
