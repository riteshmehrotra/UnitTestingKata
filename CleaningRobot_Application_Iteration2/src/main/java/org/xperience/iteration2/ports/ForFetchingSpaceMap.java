package org.xperience.iteration2.ports;

import org.xperience.iteration2.domain.entities.map.SpaceMap;
import org.xperience.iteration2.domain.exceptions.SpaceMapNotFoundException;

public interface ForFetchingSpaceMap {
    public SpaceMap fetch(String spaceId) throws SpaceMapNotFoundException;
}
