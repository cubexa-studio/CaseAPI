package org.tommy.caseapi.events;

import org.tommy.caseapi.models.Case;

import java.util.UUID;

/**
 * Event fired when a player attempts to open a case.
 * This event is cancelable. Cancelling the event will prevent the case from being opened.
 */
public class CaseOpenEvent {

    private final UUID playerUuid;
    private final Case crate;
    private boolean isCancelled;

    /**
     * Constructs a new {@code CaseOpenEvent}.
     *
     * @param playerUuid The UUID of the player who attempts to open the case.
     * @param crate The case the player is trying to open.
     */
    public CaseOpenEvent(UUID playerUuid, Case crate) {
        this.playerUuid = playerUuid;
        this.crate = crate;
        this.isCancelled = false;
    }

    /**
     * Gets the UUID of the player who attempts to open the case.
     *
     * @return The player's UUID.
     */
    public UUID getPlayerUuid() {
        return playerUuid;
    }

    /**
     * Gets the case the player is trying to open.
     *
     * @return The case instance.
     */
    public Case getCase() {
        return crate;
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
     * @param cancelled {@code true} to cancel the event and prevent the case from opening, {@code false} to allow it.
     */
    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }
}