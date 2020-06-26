package pl.proszkie.urlshortener;

public class InvalidUrlException extends RuntimeException {
    InvalidUrlException(String url) {
        super(String.format("Supplied url %s is invalid", url));
    }
}
