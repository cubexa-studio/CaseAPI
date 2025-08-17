/*
 * CaseAPI, a Minecraft plugin API by Cubexa Studio
 * Copyright (C) 2025 Cubexa Studio <https://cubexa.net>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */
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