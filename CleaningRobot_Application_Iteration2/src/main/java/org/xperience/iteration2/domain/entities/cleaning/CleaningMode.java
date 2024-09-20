package org.xperience.iteration2.domain.entities.cleaning;

import org.xperience.iteration2.domain.entities.map.SpaceMap;

import java.util.List;

public interface CleaningMode {
    void setBehaviours(List<CleaningBehaviour> behaviours);
    void execute(SpaceMap map);
}
