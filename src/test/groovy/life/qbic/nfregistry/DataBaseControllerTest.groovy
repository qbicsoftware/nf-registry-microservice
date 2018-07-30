package life.qbic.nfregistry

import groovy.json.JsonSlurper
import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class DataBaseControllerTest extends Specification {


    @Shared
    @AutoCleanup
    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)

    @Shared
    @AutoCleanup
    RxHttpClient client = embeddedServer.applicationContext.createBean(RxHttpClient, embeddedServer.getURL())

    void "test status response"() {
        when:
        HttpRequest request = HttpRequest.GET('/status')
        String rsp = client.toBlocking().retrieve(request)

        then:
        def slurper = new JsonSlurper()
        def result = slurper.parseText(rsp)

        assert result.date
        assert result.status == 'alive'
    }


}