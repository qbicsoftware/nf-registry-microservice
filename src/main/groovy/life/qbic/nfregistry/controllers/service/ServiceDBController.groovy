package life.qbic.nfregistry.controllers.service


import com.mongodb.reactivestreams.client.MongoClient
import groovy.transform.CompileStatic
import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import life.qbic.nfregistry.beans.MongoDBTester
import life.qbic.nfregistry.io.swagger.model.Status

import javax.inject.Inject
import javax.validation.constraints.NotBlank

@CompileStatic
@Controller("/service")
@ConfigurationProperties('mongodb')
class ServiceDBController {

    @Inject MongoClient mongo

    @NotBlank
    String db

    @NotBlank
    String collection

    @Get("/status")
    @Produces(MediaType.APPLICATION_JSON)
    HttpResponse<Status> getServiceStatus() {
        def serviceStatus = new Status()
        def connection = new MongoDBTester(mongo, db, collection).status
        serviceStatus.setDate(new Date().toString())
        serviceStatus.setStatus(connection)
        HttpResponse.created(serviceStatus)
    }

}
