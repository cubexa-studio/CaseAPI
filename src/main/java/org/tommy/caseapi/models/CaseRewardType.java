package org.tommy.caseapi.models;

/**
 * Defines the different types of rewards that a case can provide.
 */
public enum CaseRewardType {

    ITEM,
    GEMS,
    MONEY,
    COMMAND,
    PERMISSION;

    /**
     * Converts a string to its corresponding {@link CaseRewardType} enum value.
     * The string is case-insensitive.
     * If the string does not match any enum value, {@code null} is returned.
     *
     * @param s The string to convert.
     * @return The corresponding {@link CaseRewardType}, or {@code null} if no match was found.
     */
    public static CaseRewardType fromString(String s) {
        try {
            return CaseRewardType.valueOf(s.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}