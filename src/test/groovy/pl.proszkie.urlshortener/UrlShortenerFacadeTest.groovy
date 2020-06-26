package pl.proszkie.urlshortener

import pl.proszkie.urlshortener.db.InMemoryUrlsRepository
import pl.proszkie.urlshortener.db.UrlsRepository
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
        UrlsRepository urlsRepository = new InMemoryUrlsRepository()
        UrlShortenerFacade urlShortenerFacade = new UrlShortenerFacade(inputParameters, urlsRepository)
        String urlToShorten = "http://www.google.com"
        Url longUrl = new Url(urlToShorten);

        when:
        Url shortenedUrl = urlShortenerFacade.shorten(longUrl)
        String path = shortenedUrl.getUrl().getPath().replaceAll("/", "")

        then:
        longUrl == urlShortenerFacade.getOriginalUrlByPath(path)
    }

    def "should throw an exception when path not found"(){
        given:
        UrlsRepository urlsRepository = new InMemoryUrlsRepository()
        UrlShortenerFacade urlShortenerFacade = new UrlShortenerFacade(inputParameters, urlsRepository)

        when:
        urlShortenerFacade.getOriginalUrlByPath("dummy")

        then:
        thrown(UrlNotFoundException)
    }
}
