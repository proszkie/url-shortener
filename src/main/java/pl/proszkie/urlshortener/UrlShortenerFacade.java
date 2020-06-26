package pl.proszkie.urlshortener;

import lombok.NonNull;
import pl.proszkie.urlshortener.db.UrlsRepository;

public class UrlShortenerFacade {

    private final InputParameters inputParameters;
    private final UrlsRepository urlsRepository;

    UrlShortenerFacade(final InputParameters inputParameters, final UrlsRepository urlsRepository) {
        this.inputParameters = inputParameters;
        this.urlsRepository = urlsRepository;
    }

    public Url shorten(final Url urlToShorten) {
        String shortenerHost = inputParameters.getShortenerHost();

        final String randomlyGeneratedPath = RandomStringGenerator.generate(inputParameters.getShortenedUrlLength());

        final Url shortenedUrl = new Url(inputParameters.getShortenerProtocol(),
                shortenerHost,
                inputParameters.getShortenerPort(),
                randomlyGeneratedPath
        );

        final UrlsMapping urlsMapping = UrlsMapping.builder()
                .longUrl(urlToShorten)
                .shortenedUrlPath(shortenedUrl.getPath())
                .build();

        urlsRepository.save(urlsMapping);

        return shortenedUrl;
    }

    public Url getOriginalUrlByPath(@NonNull final String path) {
        return urlsRepository.findByShortenedUrlPath(path.replaceAll("/", ""))
                .orElseThrow(() -> new UrlNotFoundException(path));
    }
}
