package pl.proszkie.urlshortener.api;

import org.springframework.web.bind.annotation.RestController;

public interface UrlShortenerApi {

    String shortenUrl(UrlDto urlToShorten);

    String getOriginalUrl(String shortenedUrl);

}
