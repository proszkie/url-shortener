package pl.proszkie.urlshortener;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringGenerator {
    static String generate(final int shortenedUrlLength){
        return RandomStringUtils.random(shortenedUrlLength, true, true);
    }
}
