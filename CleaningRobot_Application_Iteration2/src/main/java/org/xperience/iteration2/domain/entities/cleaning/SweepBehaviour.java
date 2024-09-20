package org.xperience.iteration2.domain.entities.cleaning;

import org.xperience.iteration2.domain.entities.map.SpaceMap;

public class SweepBehaviour implements CleaningBehaviour{

    @Override
    public void perform(SpaceMap map) {
        System.out.println("Sweeping");
    }
}
