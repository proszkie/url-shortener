package pl.proszkie.urlshortener

class DummyUrlsRepository implements UrlsRepository {

    private final Map<Url, Url> urlsMapping = new HashMap<>();

    @Override
    Optional<Url> findByShortenedUrl(final Url shortenedUrl) {
        return Optional.ofNullable(urlsMapping.get(shortenedUrl))
    }

    @Override
    void save(final UrlsMapping urlsMapping) {
        this.urlsMapping.put(urlsMapping.getShortenedUrl(), urlsMapping.getLongUrl())
    }
}
