package domain.testdoubles;


import org.xperience.iteration1.domain.ForSettingSystemDateTime;

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
