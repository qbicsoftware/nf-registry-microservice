package life.qbic.nfregistry

import groovy.json.JsonSlurper
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

    void "test info response"() {
        when:
        HttpRequest request = HttpRequest.GET('/info')
        String rsp  = client.toBlocking().retrieve(request)

        then:
        def slurper = new JsonSlurper()
        def result = slurper.parseText(rsp)

        assert result
        assert result.size() == 6
        assert result.author == 'Sven Fillinger'
    }

}
