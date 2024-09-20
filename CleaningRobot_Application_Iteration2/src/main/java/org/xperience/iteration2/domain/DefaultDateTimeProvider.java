package org.xperience.iteration2.domain;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class DefaultDateTimeProvider implements ForSettingSystemDateTime {

    @Override
    public LocalDateTime get() {
        return LocalDateTime.now(ZoneId.systemDefault());
    }
}
