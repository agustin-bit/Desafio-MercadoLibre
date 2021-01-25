package meli.challenge.demo.converter;

import meli.challenge.demo.validator.DnaValidator;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListConverterTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringListConverterTest.class.getName());

    private String[] dna = {
            "ATGCGA",
            "CAGTGC",
            "TTATGT",
            "AGAAGG",
            "CCCCCA",
            "TCACTG"
    };

    @Test
    void convertToDatabaseColumn() {

        LOGGER.info("convertToDatabaseColumn test");

        String expected = "ATGCGA;CAGTGC;TTATGT;AGAAGG;CCCCCA;TCACTG";

        List<String> list = Arrays.asList(dna);
        StringListConverter stringListConverter = new StringListConverter();
        String result = stringListConverter.convertToDatabaseColumn(list);

        assertEquals(result, expected);

    }

    @Test
    void convertToEntityAttribute() {

        LOGGER.info("convertToEntityAttribute test");

        String dbColumn = "ATGCGA;CAGTGC;TTATGT;AGAAGG;CCCCCA;TCACTG";

        StringListConverter stringListConverter = new StringListConverter();
        List<String> result = stringListConverter.convertToEntityAttribute(dbColumn);
        List<String> expected = Arrays.asList(dna);

        assertEquals(expected, result);

    }

}