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
package org.tommy.caseapi.events;

import org.tommy.caseapi.models.CaseReward;
import org.tommy.caseapi.models.Case;

import java.util.UUID;

/**
 * Event fired when a player completes opening a case.
 * This event provides information about the player, the case opened, and the reward obtained.
 * This event is not cancelable and cannot be prevented once triggered.
 */
public class CaseOpenCompleteEvent {

    private final UUID playerUuid;
    private final Case crate;
    private final CaseReward caseReward;

    /**
     * Constructs a new CaseOpenCompleteEvent.
     *
     * @param playerUuid The UUID of the player who opened the case.
     * @param crate The case that was opened.
     * @param caseReward The reward obtained from the case.
     */
    public CaseOpenCompleteEvent(UUID playerUuid, Case crate, CaseReward caseReward) {
        this.playerUuid = playerUuid;
        this.crate = crate;
        this.caseReward = caseReward;
    }

    /**
     * Gets the UUID of the player who opened the case.
     *
     * @return The player's UUID.
     */
    public UUID getPlayerUuid() {
        return playerUuid;
    }

    /**
     * Gets the case that was opened.
     *
     * @return The case instance.
     */
    public Case getCase() {
        return crate;
    }

    /**
     * Gets the reward obtained from the opened case.
     *
     * @return The case reward.
     */
    public CaseReward getCaseReward() {
        return caseReward;
    }
}