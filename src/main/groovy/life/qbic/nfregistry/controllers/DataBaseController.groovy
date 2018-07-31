package life.qbic.nfregistry


import com.mongodb.reactivestreams.client.MongoClient
import groovy.json.*
import groovy.transform.CompileStatic
import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import life.qbic.nfregistry.beans.MongoDBStatus

import javax.inject.Inject
import javax.validation.constraints.NotBlank

@CompileStatic
@Controller("/status")
@ConfigurationProperties('mongodb')
class DataBaseController {

    @Inject MongoClient mongo

    @NotBlank
    String db

    @NotBlank
    String collection

    String statusJson() {
        JsonOutput.toJson(new MongoDBStatus(mongo, db, collection))
    }

    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    String index() {
        statusJson()
    }

}
