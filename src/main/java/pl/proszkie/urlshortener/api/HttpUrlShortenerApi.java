package pl.proszkie.urlshortener.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.proszkie.urlshortener.Url;
import pl.proszkie.urlshortener.UrlShortenerFacade;

import java.net.URLDecoder;
import java.nio.charset.Charset;

@RestController
@RequestMapping("/v1")
public class HttpUrlShortenerApi implements UrlShortenerApi {

    @Autowired
    private UrlShortenerFacade urlShortenerFacade;

    @Override
    @PostMapping(value = "/shorten")
    public UrlDto shortenUrl(@RequestBody final UrlDto urlToShorten) {
        Url url = new Url(URLDecoder.decode(urlToShorten.getUrl(), Charset.defaultCharset()));

        return new UrlDto(urlShortenerFacade.shorten(url));
    }

    @Override
    @GetMapping("/{path}")
    public UrlDto getOriginalUrl(@PathVariable final String path) {
        return new UrlDto(urlShortenerFacade.getOriginalUrlByPath(path));
    }
}
