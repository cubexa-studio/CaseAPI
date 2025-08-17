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
package org.tommy.caseapi.models;

/**
 * Represents a case that can be opened in the CaseOpening plugin.
 * Provides identification, display properties, and visual effects.
 */
public interface Case {

    /**
     * Gets the unique identifier of the case associated with this case.
     *
     * @return The case ID as a {@link String}.
     */
    String getCaseId();

    /**
     * Gets the display name of this case.
     *
     * @return The display name as a {@link String}.
     */
    String getDisplayName();

    /**
     * Gets the serialized representation of the case's item stack in Base64 encoding.
     *
     * @return The Base64 encoded string of the item stack as a {@link String}.
     */
    String getItemStackBase64();

    /**
     * Returns the price specified when the case was created.
     *
     * @return The price.
     */
    int getPrice();

    /**
     * Checks if this case should have a glowing visual effect.
     *
     * @return {@code true} if the case is glowing, {@code false} otherwise.
     */
    boolean isWithGlowing();

    /**
     * Returns the permission the player needs to interact with this case.
     *
     * @return The permission the player needs for this case as a {@link String}.
     */
    String getPermission();
}