package org.xperience.iteration2.domain.testdoubles;

import org.xperience.iteration2.domain.entities.cleaning.CleaningBehaviour;
import org.xperience.iteration2.domain.entities.cleaning.CleaningMode;
import org.xperience.iteration2.domain.entities.cleaning.Robot;
import org.xperience.iteration2.domain.entities.map.SpaceMap;

import java.util.List;

public class DummyCleaningMode implements CleaningMode {
    @Override
    public void setBehaviours(List<CleaningBehaviour> behaviours) {

    }

    @Override
    public void execute(SpaceMap map) {

    }
}
