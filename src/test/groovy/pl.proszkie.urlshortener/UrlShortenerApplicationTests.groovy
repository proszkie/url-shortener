package pl.proszkie.urlshortener

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class UrlShortenerApplicationTests extends Specification {

    def "context initialization"(){
        expect:
        1 == 1
    }
}
