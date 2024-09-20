package org.xperience.iteration2.domain.entities.cleaning;

import org.xperience.iteration2.domain.entities.map.SpaceMap;

public interface CleaningBehaviour {
    void perform(SpaceMap map);
}
