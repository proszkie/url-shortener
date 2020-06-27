package pl.proszkie.urlshortener.api;

public interface UrlShortenerApi {

    UrlDto shortenUrl(UrlDto urlToShorten);

    UrlDto getOriginalUrl(String shortenedUrl);

}
