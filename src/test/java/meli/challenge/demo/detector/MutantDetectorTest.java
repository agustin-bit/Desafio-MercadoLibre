package meli.challenge.demo.detector;

import meli.challenge.demo.validator.DnaValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.PostConstruct;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("dev")
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class MutantDetectorTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MutantDetectorTest.class.getName());

    private MutantDetector mutantDetector = new MutantDetector();

    @Test
    void cutTrue() {

        LOGGER.info("cutTrue test");

        boolean result = mutantDetector.cut(2);
        assertTrue(result);

    }

    @Test
    void cutFalse() {

        LOGGER.info("cutFalse test");

        boolean result = mutantDetector.cut(1);
        assertFalse(result);

    }

    @Test
    void checkSuccess() {

        LOGGER.info("checkSuccess test");

        char [][] dnaArray = {
                {'A','T','G','C','G','A'},
                {'C','A','G','T','G','C'},
                {'T','T','A','T','G','T'},
                {'A','G','A','A','G','G'},
                {'C','C','C','C','C','A'},
                {'T','C','A','C','T','G'},
        };

        boolean result = mutantDetector.check(dnaArray);
        boolean expected = true;

        assertEquals(expected, result);

    }

    @Test
    void checkFailed() {

        LOGGER.info("checkFailed test");

        char [][] dnaArray = {
                {'A','T','G','C','G','A'},
                {'C','T','G','T','G','C'},
                {'T','T','A','T','G','T'},
                {'A','G','A','A','C','G'},
                {'C','C','C','C','C','A'},
                {'T','C','A','C','T','G'},
        };

        boolean result = mutantDetector.check(dnaArray);
        boolean expected = false;

        assertEquals(expected, result);

    }

    @Test
    void searchSuccess() {

        LOGGER.info("searchSuccess test");

        char [] data = {'A', 'A', 'A', 'A', 'C', 'G'};
        int result = mutantDetector.search(data);
        int expected = 1;

        assertEquals(expected, result);

    }

    @Test
    void searchEmpty() {

        LOGGER.info("searchEmpty test");

        char [] data = {'A', 'T', 'G', 'T', 'C', 'G'};
        int result = mutantDetector.search(data);
        int expected = 0;

        assertEquals(expected, result);

    }

    @Test
    void searchMulti() {

        LOGGER.info("searchMulti test");

        char [] data = {'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'};
        int result = mutantDetector.search(data);
        int expected = 2;

        assertEquals(expected, result);

    }

}