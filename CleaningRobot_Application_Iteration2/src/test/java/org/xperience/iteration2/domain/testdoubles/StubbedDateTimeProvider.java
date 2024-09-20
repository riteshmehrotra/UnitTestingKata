package org.xperience.iteration2.domain.testdoubles;


import org.xperience.iteration2.domain.ForSettingSystemDateTime;

import java.time.LocalDateTime;

public class StubbedDateTimeProvider implements ForSettingSystemDateTime {
    LocalDateTime localDateTime;
    public StubbedDateTimeProvider(LocalDateTime incomingLocalDateTime){
        this.localDateTime = incomingLocalDateTime;
    }
    @Override
    public LocalDateTime get() {
        return localDateTime;
    }
}
