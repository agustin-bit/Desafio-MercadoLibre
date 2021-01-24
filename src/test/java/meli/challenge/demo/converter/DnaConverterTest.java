package meli.challenge.demo.converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DnaConverterTest {

    private String[] dna = {
            "ATGCGA",
            "CAGTGC",
            "TTATGT",
            "AGAAGG",
            "CCCCCA",
            "TTTTTG"
    };

    private char [][] dnaArray = {
            {'A','T','G','C','G','A'},
            {'C','A','G','T','G','C'},
            {'T','T','A','T','G','T'},
            {'A','G','A','A','G','G'},
            {'C','C','C','C','C','A'},
            {'T','C','A','C','T','G'},
    };

    private char [][] dnaTo2DCharArray = {
            {'A','T','G','C','G','A'},
            {'C','A','G','T','G','C'},
            {'T','T','A','T','G','T'},
            {'A','G','A','A','G','G'},
            {'C','C','C','C','C','A'},
            {'T','T','T','T','T','G'},
    };

    @Test
    void stringArrayTo2DCharArray() {

        char [][] result = DnaConverter.stringArrayTo2DCharArray(dna);

        assertArrayEquals(result, dnaTo2DCharArray);

    }

    @Test
    void getMatrixColumnToCharArray() {

        char[] expected = {'A', 'C', 'T', 'A', 'C', 'T'};
        char [] result = DnaConverter.getMatrixColumnToCharArray(dnaArray, 0);

        assertArrayEquals(result, expected);

    }

    @Test
    void getMatrixObliqueToCharArray() {

        char [] expected = {'A', 'A', 'A', 'A', 'C', 'G'};
        char [] result = DnaConverter.getMatrixObliqueToCharArray(dnaArray, 0, 0);

        assertArrayEquals(result, expected);

    }

    @Test
    void getMatrixInverseObliqueToCharArray() {

        char [] expected = {'A', 'G', 'T', 'A', 'C', 'T'};
        char [] result = DnaConverter.getMatrixInverseObliqueToCharArray(dnaArray, 0, 5);

        assertArrayEquals(result, expected);

    }
}