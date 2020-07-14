package pl.proszkie.urlshortener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputParameters {

    @org.springframework.beans.factory.annotation.Value("${shortenedUrlLength}")
    private int shortenedUrlLength;

    @org.springframework.beans.factory.annotation.Value("${shortenerHost}")
    @NonNull
    private String shortenerHost;

    @org.springframework.beans.factory.annotation.Value("${shortenerPort}")
    private int shortenerPort;

    @org.springframework.beans.factory.annotation.Value("${shortenerProtocol}")
    @NonNull
    private String shortenerProtocol;

    @org.springframework.beans.factory.annotation.Value("${shortenerFrontend}")
    @NonNull
    private String shortenerFrontend;
}
