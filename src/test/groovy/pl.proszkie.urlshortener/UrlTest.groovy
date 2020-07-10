package pl.proszkie.urlshortener

import spock.lang.Specification

class UrlTest extends Specification {

    def "should create valid Url"(){
        when:
        Url url = new Url(stringUrl)

        then:
        noExceptionThrown()

        where:
        stringUrl << ["http://www.google.com",
                      "www.google.com",
                      "google.com",
                      "https://www.google.com",
                      "http://google.com",
                      "https://google.com",
                      "http://google.pl"]
    }

    def "should fail when given invalid Url"(){
        when:
        Url url = new Url(stringUrl)

        then:
        thrown(InvalidUrlException)

        where:
        stringUrl << ["htt://www.google.com", "https://google", "google", "http://www.google.comaaa"]
    }
}
