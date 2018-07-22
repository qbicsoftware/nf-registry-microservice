package life.qbic.nfregistry

import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class InfoControllerTest extends Specification {

    @Shared
    @AutoCleanup
    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)

    @Shared
    @AutoCleanup
    RxHttpClient client = embeddedServer.applicationContext.createBean(RxHttpClient, embeddedServer.getURL())

    void "test hello world response"() {
        when:
        HttpRequest request = HttpRequest.GET('/info')
        String rsp  = client.toBlocking().retrieve(request)

        then:
        rsp == """\
        Version 1.0.0-alpha of the nf-registry microservice.
        Author: Sven Fillinger <sven1103> <sven.fillinger@qbic.uni-tuebingen.de>
        """.stripIndent()
    }

}
