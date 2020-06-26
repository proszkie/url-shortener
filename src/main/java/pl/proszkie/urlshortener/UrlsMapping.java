package pl.proszkie.urlshortener;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Builder
@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UrlsMapping {

    @NonNull
    private final Url longUrl;

    @NonNull
    private final String shortenedUrlPath;
}
