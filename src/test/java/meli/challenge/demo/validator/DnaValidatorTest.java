package meli.challenge.demo.validator;

import meli.challenge.demo.exception.DnaMalformatException;
import meli.challenge.demo.exception.MatrixSizeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DnaValidatorTest {

    private String[] malformated = {
            "ATGCGA",
            "CAGTGC",
            "TTATGZ",
            "AGAAGG",
            "CCCCCA",
            "TCACTG"
    };

    private String[] badSize = {
            "ATGCGA",
            "CAGTGC",
            "TTATGT",
            "AGAAGG",
            "CCCCCA"
    };

    @Test
    void checkMatrixMalformed() {

        DnaValidator dnaValidator = DnaValidator.getInstance();

        try {
            dnaValidator.checkMatrix(malformated);
        } catch (DnaMalformatException | MatrixSizeException e){
            assertTrue(e instanceof DnaMalformatException);
        }

    }

    @Test
    void checkMatrixInvalidSize() {

        DnaValidator dnaValidator = DnaValidator.getInstance();

        try {
            dnaValidator.checkMatrix(badSize);
        } catch (DnaMalformatException | MatrixSizeException e){
            assertTrue(e instanceof MatrixSizeException);
        }

    }

    @Test
    void getInstance() {

        DnaValidator dnaValidator = DnaValidator.getInstance();
        assertNotNull(dnaValidator);

    }
}