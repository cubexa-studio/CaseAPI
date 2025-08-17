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
 * Event fired when a case reward announcement is about to be sent.
 * The announcement message can be modified before broadcasting.
 * This event is cancelable. Cancelling the event will prevent the announcement from being broadcast.
 */
public class CaseRewardAnnounceEvent {

    private final UUID playerUuid;
    private final Case crate;
    private final CaseReward caseReward;
    private String announceMessage;
    private boolean isCancelled;

    /**
     * Constructs a new {@code CaseRewardAnnounceEvent}.
     *
     * @param playerUuid The UUID of the player receiving the reward.
     * @param crate The case from which the reward was obtained.
     * @param caseReward The reward to be announced.
     * @param announceMessage The message that will be broadcasted.
     */
    public CaseRewardAnnounceEvent(UUID playerUuid, Case crate, CaseReward caseReward, String announceMessage) {
        this.playerUuid = playerUuid;
        this.crate = crate;
        this.caseReward = caseReward;
        this.announceMessage = announceMessage;
    }

    /**
     * Gets the UUID of the player receiving the reward.
     *
     * @return The player's UUID.
     */
    public UUID getPlayerUuid() {
        return playerUuid;
    }

    /**
     * Gets the case from which the reward was obtained.
     *
     * @return The case instance.
     */
    public Case getCase() {
        return crate;
    }

    /**
     * Gets the reward to be announced.
     *
     * @return The case reward.
     */
    public CaseReward getCaseReward() {
        return caseReward;
    }

    /**
     * Gets the announcement message.
     *
     * @return The announcement message as a string.
     */
    public String getAnnounceMessage() {
        return announceMessage;
    }

    /**
     * Sets the announcement message.
     *
     * @param announceMessage The new announcement message.
     */
    public void setAnnounceMessage(String announceMessage) {
        this.announceMessage = announceMessage;
    }

    /**
     * Checks if this event has been cancelled.
     *
     * @return {@code true} if the event is cancelled, {@code false} otherwise.
     */
    public boolean isCancelled() {
        return isCancelled;
    }

    /**
     * Sets the cancellation state of this event.
     *
     * @param cancelled {@code true} to cancel the announcement, {@code false} to allow it.
     */
    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }
}