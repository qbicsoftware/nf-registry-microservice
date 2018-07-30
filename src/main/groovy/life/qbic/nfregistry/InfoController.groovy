package life.qbic.nfregistry

import groovy.json.JsonBuilder

import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

@Controller("/info")
@ConfigurationProperties('micronaut.application')
class InfoController {

    String author = "No author provided"

    String email = "No email provided"

    String version = "No version info provided"

    String apiv = "No API version specified"

    String institution = "No insitution info provided"

    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    String index() {
        def builder = new JsonBuilder()

        builder.'serviceInfo' {
            name "name"
            author "$author"
            email "$email"
            version "$version"
            apiv "$apiv"
            institution "$institution"
        }

        builder.toString()

    }

}
