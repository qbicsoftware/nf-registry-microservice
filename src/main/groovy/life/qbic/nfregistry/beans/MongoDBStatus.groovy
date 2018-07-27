package life.qbic.nfregistry.beans;

import com.mongodb.reactivestreams.client.MongoClient
import groovy.transform.CompileStatic

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
class MongoDBStatus {

    /**
     * The current date
     */
    Date date

    /**
     * The database connection status ("dead", "alive")
     */
    String status

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
    MongoDBStatus(MongoClient client,
                  String database,
                  String collection) {
        this.database = database
        this.collection = collection
        status = isConnected(client) ? "alive" : "dead"
        date = new Date()
    }

    /**
     * Tries to connect to the given MongoDB database
     * and collection
     * @param client A MongoDB client object
     * @return True, if connection throws no exceptions else False
     */
    Boolean isConnected(MongoClient client){
        try {
            def db = client.getDatabase(database)
            db.getCollection(collection)
        } catch( any ){
            return false
        }
        return true
    }

}
