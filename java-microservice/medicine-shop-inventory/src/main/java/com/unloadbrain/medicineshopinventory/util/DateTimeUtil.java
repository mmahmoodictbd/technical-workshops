package com.unloadbrain.medicineshopinventory.util;

import java.time.Instant;

/**
 * Provides date related utils.
 */
public class DateTimeUtil {

    /**
     * Gets current time epoch milli.
     *
     * @return the current time epoch milli
     */
    public long getCurrentTimeEpochMilli() {
        return Instant.now().toEpochMilli();
    }
}
