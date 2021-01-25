package meli.challenge.demo.validator;

import meli.challenge.demo.exception.DnaMalformatException;
import meli.challenge.demo.exception.MatrixSizeException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class DnaValidatorTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DnaValidatorTest.class.getName());

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

        LOGGER.info("checkMatrixMalformed test");

        DnaValidator dnaValidator = DnaValidator.getInstance();

        try {
            dnaValidator.checkMatrix(malformated);
        } catch (DnaMalformatException | MatrixSizeException e){
            assertTrue(e instanceof DnaMalformatException);
        }

    }

    @Test
    void checkMatrixInvalidSize() {

        LOGGER.info("checkMatrixInvalidSize test");

        DnaValidator dnaValidator = DnaValidator.getInstance();

        try {
            dnaValidator.checkMatrix(badSize);
        } catch (DnaMalformatException | MatrixSizeException e){
            assertTrue(e instanceof MatrixSizeException);
        }

    }

    @Test
    void getInstance() {

        LOGGER.info("getInstance singleton test");

        DnaValidator dnaValidator = DnaValidator.getInstance();
        assertNotNull(dnaValidator);

    }
}