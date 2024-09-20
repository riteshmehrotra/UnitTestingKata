package org.xperience.iteration2.domain.testdoubles;

import org.xperience.iteration2.domain.entities.cleaning.CleaningBehaviour;
import org.xperience.iteration2.domain.entities.map.SpaceMap;

public class MockSweepingBehaviour implements CleaningBehaviour {
    private int counter = 0;
    private SpaceMap lastSpaceMap;

    @Override
    public void perform(SpaceMap map) {
        counter++;
        this.lastSpaceMap = map;
    }

    public boolean calledWith(SpaceMap expectedMap) {
        return lastSpaceMap != null && lastSpaceMap.equals(expectedMap);
    }

    public void verify(int expectedCalls, SpaceMap expectedMap) {
        if (counter != expectedCalls) {
            throw new AssertionError("Expected " + expectedCalls + " calls, but got " + counter);
        }
        if (!calledWith(expectedMap)) {
            throw new AssertionError("Expected to be called with " + expectedMap + ", but was called with " + lastSpaceMap);
        }
    }

    public void reset() {
        counter = 0;
        lastSpaceMap = null;
    }
}

