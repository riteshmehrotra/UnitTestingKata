package org.xperience.iteration2.domain.entities.cleaning;

import org.xperience.iteration2.domain.entities.map.SpaceMap;

import java.util.List;

public class DefaultCleaningMode implements CleaningMode {
    List<CleaningBehaviour> behaviours;

    @Override
    public void setBehaviours(List<CleaningBehaviour> behaviours) {
        this.behaviours = behaviours;
    }

    @Override
    public void execute(SpaceMap map) {
        behaviours.forEach(behaviour -> behaviour.perform(map));
    }
}
