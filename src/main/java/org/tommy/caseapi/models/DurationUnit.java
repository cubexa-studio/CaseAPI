package org.tommy.caseapi.models;

/**
 * Represents units of time duration.
 */
public enum DurationUnit {

    SECONDS,
    MINUTES,
    HOURS,
    DAYS,
    WEEKS,
    MONTHS,
    YEARS,
    INFINITE;

    /**
     * Converts a string to its corresponding {@link DurationUnit} enum value.
     * The string comparison is case-insensitive.
     * If the string does not match any enum value, {@code null} is returned.
     *
     * @param s The string representation of the duration unit.
     * @return The corresponding {@link DurationUnit}, or {@code null} if no match was found.
     */
    public static DurationUnit fromString(String s) {
        try {
            return DurationUnit.valueOf(s.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}