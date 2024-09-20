package org.xperience.iteration2.domain.testdoubles;

import org.xperience.iteration2.domain.entities.cleaning.MopBehaviour;
import org.xperience.iteration2.domain.entities.cleaning.SweepBehaviour;
import org.xperience.iteration2.domain.entities.map.SpaceMap;

public class SpyMoppingBehaviour extends MopBehaviour {
    private int sweepCounter;
    private SpaceMap spaceMap;

    @Override
    public void perform(SpaceMap map) {
        sweepCounter++;
        this.spaceMap=map;
        super.perform(spaceMap);
    }

    public int timesCalled(){
        return sweepCounter;
    }

    public boolean calledWith(SpaceMap expectedMap){
        return spaceMap.equals(expectedMap);
    }

}
