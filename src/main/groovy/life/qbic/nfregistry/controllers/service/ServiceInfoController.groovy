package life.qbic.nfregistry.controllers.service


import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import life.qbic.nfregistry.io.swagger.model.Info
import life.qbic.nfregistry.io.swagger.model.Status

@Controller("/service")
@ConfigurationProperties('micronaut.application')
class ServiceInfoController {

    String name = "No app name provided"

    String author = "No author provided"

    String email = "No email provided"

    String version = "No version info provided"

    String apiv = "No API version specified"

    String institution = "No insitution info provided"

    @Get("/info")
    @Produces(MediaType.APPLICATION_JSON)
    HttpResponse<Info> getServiceInfo() {

        def info = new Info()
        info.with {
            name = this.name
            author = this.author
            email = this.email
            version = this.version
            apiv = this.apiv
            institution = this.institution
        }
        HttpResponse.created(info)
    }







}
