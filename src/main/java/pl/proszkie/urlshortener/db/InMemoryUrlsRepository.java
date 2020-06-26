package pl.proszkie.urlshortener.db;

import pl.proszkie.urlshortener.Url;
import pl.proszkie.urlshortener.UrlsMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryUrlsRepository implements UrlsRepository {

    Map<String, Url> mapping = new HashMap<>();

    @Override
    public Optional<Url> findByShortenedUrlPath(final String shortenedUrl) {
        return Optional.ofNullable(mapping.get(shortenedUrl));
    }

    @Override
    public void save(final UrlsMapping urlsMapping) {
        mapping.put(urlsMapping.getShortenedUrlPath(), urlsMapping.getLongUrl());
    }
}
