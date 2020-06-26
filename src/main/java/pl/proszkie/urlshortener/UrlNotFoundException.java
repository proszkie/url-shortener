package pl.proszkie.urlshortener;

public class UrlNotFoundException extends RuntimeException {
    public UrlNotFoundException(final String path) {
        super(String.format("Shortened url with path %s not found", path));
    }
}