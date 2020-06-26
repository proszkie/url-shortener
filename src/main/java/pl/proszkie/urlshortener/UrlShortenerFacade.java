package pl.proszkie.urlshortener;

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
                .shortenedUrl(shortenedUrl)
                .build();

        urlsRepository.save(urlsMapping);

        return shortenedUrl;
    }

    public Url getOriginalUrl(final Url shortenedUrl) {
        return urlsRepository.findByShortenedUrl(shortenedUrl)
                .orElseThrow(() -> new UrlNotFoundException(shortenedUrl));
    }
}
