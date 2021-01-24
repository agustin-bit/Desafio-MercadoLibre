package meli.challenge.demo.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MutantDtoTest {

    @Test
    void builder() {

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