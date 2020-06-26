package pl.proszkie.urlshortener

import spock.lang.Specification

import java.util.regex.Pattern

//Exploratory test
class RandomStringGeneratorTest extends Specification {

    def "should generate random alphanumeric string"(){
        def stringLength = 9999999
        when:
        String randomlyGeneneratedString = RandomStringGenerator.generate(stringLength)
        then:
        randomlyGeneneratedString.length() == stringLength
        randomlyGeneneratedString.find(Pattern.compile("^[a-zA-Z0-9_]*\$"))
    }
}
