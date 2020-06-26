package pl.proszkie.urlshortener

import spock.lang.Specification

class UrlShortenerFacadeTest extends Specification {
    static final int SHORTENED_URL_LENGTH = 6;

    InputParameters inputParameters = InputParameters.builder()
            .shortenedUrlLength(SHORTENED_URL_LENGTH)
            .shortenerHost("127.0.0.1")
            .shortenerProtocol("http://")
            .shortenerPort(8080)
            .build()


    def "should map long url with shortened url"(){
        given:
        UrlsRepository urlsRepository = new DummyUrlsRepository()
        UrlShortenerFacade urlShortenerFacade = new UrlShortenerFacade(inputParameters, urlsRepository)
        String urlToShorten = "http://www.google.com"
        Url longUrl = new Url(urlToShorten);

        when:
        Url shortenedUrl = urlShortenerFacade.shorten(longUrl)

        then:
        longUrl == urlShortenerFacade.getOriginalUrl(shortenedUrl)
    }
}
