package pl.proszkie.urlshortener;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.apache.commons.validator.routines.UrlValidator;

import java.net.MalformedURLException;
import java.net.URL;

public class Url {

    @Getter
    private URL url;

    public Url(final String protocol, final String host, final int port, final String path){
        this(protocol + host + ":" + port + "/" + path);
    }

    public Url(@NonNull final String url) {
        //localhost is discriminated here
        String transformedUrl = transformUrl(url);
        validate(url, transformedUrl);
    }

    private void validate(final String url, final String transformedUrl) {
        if(UrlValidator.getInstance().isValid(transformedUrl)){
            try {
                this.url = new URL(transformedUrl);
            } catch (MalformedURLException e) {
                throw new InvalidUrlException(url);
            }
        }else {
            throw new InvalidUrlException(url);
        }
    }

    private String transformUrl(final String url) {
        StringBuilder urlBuilder = new StringBuilder();

        if(!url.startsWith("http://") && !url.startsWith("https://")){
            urlBuilder.append("http://");
        }

        urlBuilder.append(url);

        return urlBuilder.toString();
    }

    public String getPath() {
        return this.url.getPath().replaceAll("/", "");
    }
}
