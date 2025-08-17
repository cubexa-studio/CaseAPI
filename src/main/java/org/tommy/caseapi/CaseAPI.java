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
package org.tommy.caseapi;

import org.tommy.caseapi.events.CaseOpeningEventListener;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * The CaseAPI interface provides methods to interact with the CaseOpening.
 * It allows opening cases, managing players' gems and cases, retrieving statistics and listening for events.
 */
public interface CaseAPI {

    /**
     * Checks if a case with the given ID exists.
     *
     * @param caseId The ID of the case to check.
     * @return A {@link CompletableFuture} that completes with {@code true} if the case exists, {@code false} otherwise.
     */
    CompletableFuture<Boolean> caseExists(String caseId);

    /**
     * Opens a case for a player and removes one from them.
     *
     * @param playerUuid The uuid of the player opening the case.
     * @param caseId The ID of the case to open.
     * @return A {@link CompletableFuture} that completes with {@code true} if the case was successfully opened, {@code false} otherwise.
     */
    CompletableFuture<Boolean> openCaseWithRemove(UUID playerUuid, String caseId);

    /**
     * Opens a case for a player without removing it.
     *
     * @param playerUuid The uuid of the player opening the case.
     * @param caseId The ID of the case to open.
     * @return A {@link CompletableFuture} that completes with {@code true} if the case was successfully opened, {@code false} otherwise.
     */
    CompletableFuture<Boolean> openCaseWithoutRemove(UUID playerUuid, String caseId);

    /**
     * Opens a case preview for a player.
     *
     * @param playerUuid The UUID of the player who should see the preview.
     * @param caseId The ID of the case to preview.
     */
    void openCasePreview(UUID playerUuid, String caseId);

    /**
     * Sets the amount of jewelry a player has.
     *
     * @param playerUuid The uuid of the player whose jewelry amount will be set.
     * @param amount The amount of jewelry to set.
     */
    void setJewelry(UUID playerUuid, int amount);

    /**
     * Adds a specific amount of jewelry to the given player.
     *
     * @param playerUuid The uuid of the player to receive the jewelry.
     * @param amount The amount of jewelry to add.
     */
    void addJewelry(UUID playerUuid, int amount);

    /**
     * Removes a specific amount of jewelry from the given player.
     *
     * @param playerUuid The uuid of the player whose jewelry will be removed.
     * @param amount The amount of jewelry to remove.
     */
    void removeJewelry(UUID playerUuid, int amount);

    /**
     * Sets the amount of a specific case a player has.
     *
     * @param playerUuid The uuid of the player whose cases will be set.
     * @param caseId The ID of the case to set.
     * @param amount The amount of cases to set.
     */
    void setCases(UUID playerUuid, String caseId, int amount);

    /**
     * Adds a specified number of cases to a player.
     *
     * @param playerUuid The uuid of the player receiving the cases.
     * @param caseId The ID of the case to add.
     * @param amount The number of cases to add.
     */
    void addCases(UUID playerUuid, String caseId, int amount);

    /**
     * Removes a specified number of cases from a player.
     *
     * @param playerUuid The uuid of the player losing the cases.
     * @param caseId The ID of the case to remove.
     * @param amount The number of cases to remove.
     */
    void removeCases(UUID playerUuid, String caseId, int amount);

    /**
     * Retrieves the current amount of jewelry owned by the given player.
     *
     * @param playerUuid The uuid of the player whose jewelry amount is requested.
     * @return The current amount of jewelry the player owns as a {@link CompletableFuture}.
     */
    CompletableFuture<Integer> getJewelry(UUID playerUuid);

    /**
     * Gets the number of a specific case a player owns.
     *
     * @param playerUuid The uuid of the player whose case count is retrieved.
     * @param caseId The ID of the case.
     * @return The number of cases the player owns as a {@link CompletableFuture}.
     */
    CompletableFuture<Integer> getPlayerCases(UUID playerUuid, String caseId);

    /**
     * Gets the total number of cases opened globally.
     *
     * @return The total number of opened cases as a {@link CompletableFuture}.
     */
    CompletableFuture<Integer> getTotalCasesOpened();

    /**
     * Gets the total number of cases opened by a specific player.
     *
     * @param playerUuid The uuid of the player whose case opening count is retrieved.
     * @return The total number of cases opened by the player as a {@link CompletableFuture}.
     */
    CompletableFuture<Integer> getTotalCasesOpenedByPlayer(UUID playerUuid);

    /**
     * Registers a new {@link CaseOpeningEventListener} to receive CaseAPI events.
     * If multiple listeners are registered, the last registered listener has the highest priority
     * and will be called last, allowing it to override or react after others.
     *
     * @param listener The listener to register.
     */
    void registerListener(CaseOpeningEventListener listener);

    /**
     * Unregisters a previously registered {@link CaseOpeningEventListener}, preventing it from receiving further events.
     *
     * @param listener The listener to unregister.
     */
    void unregisterListener(CaseOpeningEventListener listener);
}