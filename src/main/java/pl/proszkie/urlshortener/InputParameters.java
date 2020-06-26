package pl.proszkie.urlshortener;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class InputParameters {

    @org.springframework.beans.factory.annotation.Value("{shortenedUrlLength}")
    @NonNull
    private int shortenedUrlLength;

    @org.springframework.beans.factory.annotation.Value("{shortenerHost}")
    @NonNull
    private String shortenerHost;

    @org.springframework.beans.factory.annotation.Value("{shortenerPort}")
    @NonNull
    private int shortenerPort;

    @org.springframework.beans.factory.annotation.Value("{shortenerProtocol}")
    @NonNull
    private String shortenerProtocol;
}
