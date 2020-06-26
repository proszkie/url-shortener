package pl.proszkie.urlshortener;

import java.util.Optional;

public interface UrlsRepository {
    Optional<Url> findByShortenedUrl(Url shortenedUrl);

    void save(UrlsMapping urlsMapping);
}
