package pl.proszkie.urlshortener.db;

import pl.proszkie.urlshortener.Url;
import pl.proszkie.urlshortener.UrlsMapping;

import java.util.Optional;

public interface UrlsRepository {
    Optional<Url> findByShortenedUrlPath(String shortenedUrl);

    void save(UrlsMapping urlsMapping);
}
