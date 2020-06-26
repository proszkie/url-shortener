package pl.proszkie.urlshortener;

public class UrlNotFoundException extends RuntimeException {
    public UrlNotFoundException(final Url url) {
        super(String.format("Url %s not found", url.getWhole()));
    }
}