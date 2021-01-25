package meli.challenge.demo.dto;

import meli.challenge.demo.validator.DnaValidator;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class MutantDtoTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MutantDtoTest.class.getName());

    @Test
    void builder() {

        LOGGER.info("builder test");

        String[] dna = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCCA",
                "CCCCCA"
        };

        MutantDto result = MutantDto.builder().dna(dna).build();

        assertNotNull(result);
        assertEquals(result.getDna().length, 6);

    }
}