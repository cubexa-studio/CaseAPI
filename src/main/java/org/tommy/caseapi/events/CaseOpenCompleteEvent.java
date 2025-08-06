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