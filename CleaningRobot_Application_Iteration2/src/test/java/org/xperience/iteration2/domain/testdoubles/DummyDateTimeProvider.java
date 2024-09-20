package org.xperience.iteration2.domain.testdoubles;

import org.xperience.iteration2.domain.ForSettingSystemDateTime;

import java.time.LocalDateTime;

public class DummyDateTimeProvider implements ForSettingSystemDateTime {
    @Override
    public LocalDateTime get() {
        return null;
    }
}
