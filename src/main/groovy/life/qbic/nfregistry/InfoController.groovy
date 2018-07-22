package life.qbic.nfregistry

import groovy.transform.CompileStatic
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

@CompileStatic
@Controller("/info")
class InfoController {
    @Get("/")
    @Produces(MediaType.TEXT_PLAIN)
    String index() {
        """\
        Version 1.0.0-alpha of the nf-registry microservice.
        Author: Sven Fillinger <sven1103> <sven.fillinger@qbic.uni-tuebingen.de>
        """.stripIndent()
    }

}
