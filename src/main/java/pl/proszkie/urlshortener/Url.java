package pl.proszkie.urlshortener;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.validator.routines.UrlValidator;

import java.net.MalformedURLException;
import java.net.URL;

public class Url {

    @Getter
    private URL url;

    Url(final String protocol, final String host, final int port, final String path){
        this(protocol + host + ":" + port + "/" + path);
    }

    Url(final String url) {
        //localhost is discriminated here
        if(UrlValidator.getInstance().isValid(url)){
            try {
                this.url = new URL(url);
            } catch (MalformedURLException e) {
                throw new InvalidUrlException(url);
            }
        }else {
            throw new InvalidUrlException(url);
        }
    }

    String getWhole() {
        return url.toExternalForm();
    }
}