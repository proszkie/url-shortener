package pl.proszkie.urlshortener.api;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.proszkie.urlshortener.Url;

@Data
@NoArgsConstructor
public class UrlDto {
    private String url;
    private String path;

    UrlDto(final Url url) {
        this.url = url.getUrl().toExternalForm();
        this.path = url.getPath();
    }
}
