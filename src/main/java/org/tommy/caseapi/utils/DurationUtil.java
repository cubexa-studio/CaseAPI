package org.tommy.caseapi.utils;

import org.tommy.caseapi.models.DurationUnit;

import java.time.Duration;

/**
 * Utility class for working with {@link Duration} values based on custom {@link DurationUnit}s.
 */
public class DurationUtil {

    /**
     * Converts a given amount and unit to a {@link Duration}.
     * If the unit is {@code null}, {@link Duration}.ZERO is returned.
     *
     * @param amount The amount of time.
     * @param unit The unit corresponding to the amount.
     * @return A {@link Duration} representing the given time span, or {@link Duration}.ZERO if the unit is {@code null} or unknown.
     */
    public static Duration getDuration(long amount, DurationUnit unit) {
        if (unit == null) return Duration.ZERO;
        return switch (unit) {
            case SECONDS -> Duration.ofSeconds(amount);
            case MINUTES -> Duration.ofMinutes(amount);
            case HOURS -> Duration.ofHours(amount);
            case DAYS -> Duration.ofDays(amount);
            case WEEKS -> Duration.ofDays(amount * 7);
            case MONTHS -> Duration.ofDays(amount * 30);
            case YEARS -> Duration.ofDays(amount * 365);
            default -> Duration.ZERO;
        };
    }
}