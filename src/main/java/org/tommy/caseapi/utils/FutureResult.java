package org.tommy.caseapi.utils;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Represents a future result of an asynchronous operation, abstracting over a {@link CompletableFuture}.
 * Subclasses define how and where callbacks are executed.
 *
 * <p>Example subclass implementation:</p>
 *
 * <pre>{@code
 * public class BukkitFutureResult<T> extends FutureResult<T> {
 *
 *     private BukkitFutureResult(CompletableFuture<T> future) {
 *         super(future);
 *     }
 *
 *     public static <T> BukkitFutureResult<T> of(CompletableFuture<T> future) {
 *         return new BukkitFutureResult<>(future);
 *     }
 *
 *     @Override
 *     public void whenComplete(Consumer<? super T> callback) {
 *         var executor = (Executor) r -> Bukkit.getScheduler().runTask(CaseOpeningPlugin.getInstance(), r);
 *         this.future.thenAcceptAsync(callback, executor);
 *     }
 *
 *     @Override
 *     public void whenComplete(Consumer<? super T> callback, Consumer<Throwable> throwableConsumer) {
 *         var executor = (Executor) r -> Bukkit.getScheduler().runTask(CaseOpeningPlugin.getInstance(), r);
 *         this.future.thenAcceptAsync(callback, executor).exceptionally(throwable -> {
 *             throwableConsumer.accept(throwable);
 *             return null;
 *         });
 *     }
 * }
 * }</pre>
 *
 * @param <T> The type of the result.
 */
public abstract class FutureResult<T> {

    /**
     * The underlying {@link CompletableFuture} that holds the result.
     */
    protected final CompletableFuture<T> future;

    /**
     * Constructs a new {@link FutureResult} instance with the given future.
     *
     * @param future The {@link CompletableFuture} backing this result.
     */
    protected FutureResult(CompletableFuture<T> future) {
        this.future = future;
    }

    /**
     * Registers a callback to be executed when the result becomes available.
     *
     * @param callback The callback to execute with the result.
     */
    public abstract void whenComplete(Consumer<? super T> callback);

    /**
     * Registers a callback to be executed when the result becomes available,
     * and a separate callback for handling any exceptions.
     *
     * @param callback The callback to execute with the result.
     * @param throwableConsumer The callback to execute if an exception occurs.
     */
    public abstract void whenComplete(Consumer<? super T> callback, Consumer<Throwable> throwableConsumer);

    /**
     * Waits for the future to complete and returns the result.
     *
     * @return The completed result.
     */
    public T join() {
        return this.future.join();
    }

    /**
     * Returns the underlying {@link CompletableFuture}, preserving the result type.
     *
     * @return The wrapped {@link CompletableFuture}.
     */
    public CompletableFuture<T> asFuture() {
        return this.future.thenApply(Function.identity());
    }
}