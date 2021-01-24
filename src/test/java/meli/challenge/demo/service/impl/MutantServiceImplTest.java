package meli.challenge.demo.service.impl;

import meli.challenge.demo.detector.MutantDetector;
import meli.challenge.demo.model.Mutant;
import meli.challenge.demo.repository.MutantRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(MockitoExtension.class)
class MutantServiceImplTest {

    @Mock
    private MutantDetector mutantDetector;

    @Mock
    private MutantRepository mutantRepository;

    @InjectMocks
    private MutantServiceImpl mutantService;

    @Before
    public void init(){

        mutantService = new MutantServiceImpl();

    }

    private String[] failed = {
            "ATGCGA",
            "CAGTGC",
            "TTGTGA",
            "AGAAGG",
            "CTCCCA",
            "TCACTG"
    };

    @Test
    void isMutantFalse() {

        mutantService = Mockito.mock(MutantServiceImpl.class);
        assertFalse(mutantService.isMutant(failed));

    }
}