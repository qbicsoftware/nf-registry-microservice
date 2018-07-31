package life.qbic.nfregistry.subscribers

import com.mongodb.MongoTimeoutException
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

/**
 * A simple Subscriber implementation
 *
 * Can be used to subscribe on Publishers and receive
 * Objects of Type <T>.
 * This class also uses a CountDownLatch, which only expects
 * 1 worker thread by default in this implementation.
 *
 * Found this on GitHub:
 * https://github.com/mongodb/mongo-java-driver-reactivestreams/blob/master/examples/tour/src/main/tour/SubscriberHelpers.java
 *
 * @param <T> A generic type
 */
class SimpleSubscriber<T> implements Subscriber<T>{

    private final List<T> received
    private final List<Throwable> errors
    private final CountDownLatch latch
    private volatile Subscription subscription
    private volatile boolean completed

    SimpleSubscriber(){
        received = new ArrayList<T>()
        errors = new ArrayList<Throwable>()
        latch = new CountDownLatch(1)
    }


    @Override
    void onSubscribe(Subscription s) {
        subscription = s
    }

    @Override
    void onNext(final T t) {
        received.add(t)
    }

    @Override
    void onError(final Throwable t) {
        errors.add(t)
        onComplete()
    }

    @Override
    void onComplete() {
        completed = true
        latch.countDown()
    }

    Subscription getSubscription() {
        return subscription
    }

    List<T> getReceived() {
        return received
    }

    Throwable getError() {
        if (errors.size() > 0) {
            return errors.get(0)
        }
        return null
    }

    boolean isCompleted() {
        return completed
    }

    List<T> get(final long timeout, final TimeUnit unit) throws Throwable {
        return await(timeout, unit).getReceived()
    }

    SimpleSubscriber<T> await() throws Throwable {
        return await(Long.MAX_VALUE, TimeUnit.MILLISECONDS)
    }

    SimpleSubscriber<T> await(final long timeout, final TimeUnit unit) throws Throwable {
        subscription.request(Integer.MAX_VALUE)
        if (!latch.await(timeout, unit)) {
            throw new MongoTimeoutException("Publisher onComplete timed out")
        }
        if (!errors.isEmpty()) {
            throw errors.get(0)
        }
        return this
    }
}
