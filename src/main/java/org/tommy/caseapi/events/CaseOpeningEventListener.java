package org.tommy.caseapi.events;

/**
 * Listener interface for handling CaseOpening related events.
 */
public interface CaseOpeningEventListener {

    /**
     * Called when a player attempts to open a case.
     * This event is cancelable. Cancelling it will prevent the case from opening.
     *
     * @param event The {@link CaseOpenEvent} instance.
     */
    void onCaseOpen(CaseOpenEvent event);

    /**
     * Called when a player has successfully completed opening a case.
     * This event is not cancelable.
     *
     * @param event The {@link CaseOpenCompleteEvent} instance.
     */
    void onCaseOpenComplete(CaseOpenCompleteEvent event);

    /**
     * Called when a player fails to open a case.
     * This event is not cancelable.
     *
     * @param event The {@link FailedCaseOpenEvent} instance.
     */
    void onFailedCaseOpen(FailedCaseOpenEvent event);

    /**
     * Called when a case reward announcement is about to be sent.
     * The announcement message can also be modified.
     * This event is cancelable. Cancelling it will prevent the announcement.
     *
     * @param event The {@link CaseRewardAnnounceEvent} instance.
     */
    void onCaseRewardAnnounce(CaseRewardAnnounceEvent event);
}