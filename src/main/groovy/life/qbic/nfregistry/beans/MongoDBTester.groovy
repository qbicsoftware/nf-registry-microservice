package life.qbic.nfregistry.beans

import com.mongodb.reactivestreams.client.MongoClient
import groovy.transform.CompileStatic
import life.qbic.nfregistry.io.swagger.model.Status
import life.qbic.nfregistry.subscribers.SimpleSubscriber
import org.bson.Document
import org.reactivestreams.Publisher
import org.reactivestreams.Subscriber

import java.util.concurrent.TimeUnit

/**
 * Small bean that contains the status information
 * about the MongoDB connection.
 *
 * If the connection to the database fails for some reason
 * the status is set to "dead", otherwise it is "alive".
 *
 * The two main properties are:
 *
 *      - Date date: contains the current date of the object creation
 *      - String status: contains the current connection status
 *
 */
@CompileStatic
class MongoDBTester {

    /**
     * The current date
     */
    Date date

    /**
     * The database connection status ("dead", "alive")
     */
    Status.StatusEnum status

    /**
     * A MongoDB collection name
     */
    private final String collection

    /**
     * A MongoDB database name
     */
    private final String database

    /**
     * The object constructor
     *
     * Will directly test the database connection
     * on initiation.
     *
     * @param client A MongoClient object
     * @param database A MongoDB database name
     * @param collection A MongoSB collection name
     */
    MongoDBTester(MongoClient client,
                  String database,
                  String collection) {
        this.database = database
        this.collection = collection
        status = isConnected(client) ? Status.StatusEnum.ALIVE
                : Status.StatusEnum.DEAD
    }

    /**
     * Tries to connect to the given MongoDB database
     * and collection
     * @param client A MongoDB client object
     * @return True, if connection throws no exceptions else False
     */
    Boolean isConnected(MongoClient client) {
        // Create a publisher

        Publisher<Document> publisher = client.getDatabase(database)
                .getCollection(collection).find()
        Subscriber<Document> subscriber = new SimpleSubscriber<>()
        publisher.subscribe(subscriber)
        try {
            subscriber.await(5000, TimeUnit.MILLISECONDS)
        } catch (any) {
            any.printStackTrace()
            return false
        }
        return true

    }

}
