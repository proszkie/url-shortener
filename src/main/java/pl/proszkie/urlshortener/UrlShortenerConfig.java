package pl.proszkie.urlshortener;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.proszkie.urlshortener.db.InMemoryUrlsRepository;

@Configuration
@EnableConfigurationProperties(InputParameters.class)
public class UrlShortenerConfig {

    @Bean
    UrlShortenerFacade urlShortenerFacade(final InputParameters inputParameters){
        return new UrlShortenerFacade(inputParameters, new InMemoryUrlsRepository());
    }
}
