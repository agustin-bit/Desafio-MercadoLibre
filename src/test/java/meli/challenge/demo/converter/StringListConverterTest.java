package meli.challenge.demo.converter;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListConverterTest {

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

        String expected = "ATGCGA;CAGTGC;TTATGT;AGAAGG;CCCCCA;TCACTG";

        List<String> list = Arrays.asList(dna);
        StringListConverter stringListConverter = new StringListConverter();
        String result = stringListConverter.convertToDatabaseColumn(list);

        assertEquals(result, expected);

    }

    @Test
    void convertToEntityAttribute() {

        String dbColumn = "ATGCGA;CAGTGC;TTATGT;AGAAGG;CCCCCA;TCACTG";

        StringListConverter stringListConverter = new StringListConverter();
        List<String> result = stringListConverter.convertToEntityAttribute(dbColumn);
        List<String> expected = Arrays.asList(dna);

        assertEquals(expected, result);

    }

}