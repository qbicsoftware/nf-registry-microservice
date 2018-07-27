package life.qbic.nfregistry

import groovy.json.*
import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import com.mongodb.reactivestreams.client.MongoClient
import io.micronaut.http.annotation.Produces
import life.qbic.nfregistry.beans.MongoDBStatus

import javax.inject.Inject
import javax.validation.constraints.NotBlank

@Controller("/status")
@ConfigurationProperties('mongodb')
class DataBaseController {

    @Inject MongoClient mongoClient

    @NotBlank
    String db

    @NotBlank
    String collection

    String statusJson() {
        JsonOutput.toJson(new MongoDBStatus(mongoClient, db, collection))
    }

    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    String index() {
        statusJson()
    }

}
