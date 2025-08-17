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

import java.time.Duration;

/**
 * Represents a reward within a case system.
 * Provides information about the reward type, chances, availability, and associated effects.
 */
public interface CaseReward {

    /**
     * Gets the type of this case reward.
     *
     * @return The {@link CaseRewardType} of this reward.
     */
    CaseRewardType getType();

    /**
     * Calculates the win chance of this reward based on the total chance.
     *
     * @param totalChance The total chance value used for normalization.
     * @return The calculated win chance as a {@code double}.
     */
    double getWinChance(double totalChance);

    /**
     * Gets the base chance of winning this reward.
     *
     * @return The base chance as a {@code double}.
     */
    double getChance();

    /**
     * Gets the serialized representation of the reward's item stack in Base64 encoding.
     *
     * @return The Base64 encoded string of the item stack.
     */
    String getItemStackBase64();

    /**
     * Checks if this reward should trigger a broadcast message upon winning.
     *
     * @return {@code true} if a broadcast message should be sent, {@code false} otherwise.
     */
    boolean isWithBroadcastMessage();

    /**
     * Gets the index of this reward within the case.
     *
     * @return The index as an {@code int}.
     */
    int getIndex();

    /**
     * Sets the index of this reward within the case.
     *
     * @param index The index to set.
     * @return This {@link CaseReward} instance for chaining.
     */
    CaseReward setIndex(int index);

    /**
     * Checks if this reward has a limited number of draws.
     *
     * @return {@code true} if the reward is limited, {@code false} otherwise.
     */
    boolean isLimited();

    /**
     * Checks if this reward is currently available to be won.
     *
     * @return {@code true} if available, {@code false} otherwise.
     */
    boolean isAvailable();

    /**
     * Gets the maximum number of times this reward can be drawn.
     *
     * @return The maximum draws as an {@code int}.
     */
    int getMaxDraws();

    /**
     * Gets the remaining number of draws left for this reward.
     *
     * @return The remaining draws as an {@code int}.
     */
    int getRemainingDraws();

    /**
     * Reduces the remaining draws by one.
     */
    void reduceRemainingDraws();

    /**
     * Gets the amount of gems awarded by this reward, if any.
     *
     * @return The amount of gems as an {@link Integer}, or {@code null} if none.
     */
    Integer getGemsAmount();

    /**
     * Gets the amount of money awarded by this reward, if any.
     *
     * @return The amount of money as a {@link Double}, or {@code null} if none.
     */
    Double getMoneyAmount();

    /**
     * Gets the command associated with this reward, if any.
     *
     * @return The command string, or {@code null} if none.
     */
    String getCommand();

    /**
     * Gets the permission granted by this reward, if any.
     *
     * @return The permission string, or {@code null} if none.
     */
    String getPermission();

    /**
     * Gets the duration for which the permission granted by this reward is valid.
     *
     * @return The {@link Duration} of the permission, or {@code null} if none.
     */
    Duration getPermissionDuration();
}