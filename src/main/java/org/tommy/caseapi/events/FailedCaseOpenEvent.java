package org.tommy.caseapi.events;

import org.tommy.caseapi.models.Case;

import java.util.UUID;

/**
 * Event fired when a player fails to open a case.
 * This event is not cancelable and serves only as a notification.
 */
public class FailedCaseOpenEvent {

    private final UUID playerUuid;
    private final Case crate;

    /**
     * Constructs a new {@code FailedCaseOpenEvent}.
     *
     * @param playerUuid The UUID of the player who failed to open the case.
     * @param crate The case the player attempted to open.
     */
    public FailedCaseOpenEvent(UUID playerUuid, Case crate) {
        this.playerUuid = playerUuid;
        this.crate = crate;
    }

    /**
     * Gets the UUID of the player who failed to open the case.
     *
     * @return The player's UUID.
     */
    public UUID getPlayerUuid() {
        return playerUuid;
    }

    /**
     * Gets the case the player attempted to open.
     *
     * @return The case instance.
     */
    public Case getCase() {
        return crate;
    }
}