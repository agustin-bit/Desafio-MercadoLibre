package meli.challenge.demo.service.impl;

import meli.challenge.demo.dto.StatsDto;
import meli.challenge.demo.repository.MutantRepository;
import meli.challenge.demo.service.StatsService;
import meli.challenge.demo.validator.DnaValidator;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ActiveProfiles("dev")
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StatsServiceImplTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StatsServiceImplTest.class.getName());

    @Mock
    private MutantRepository mutantRepository;

    @InjectMocks
    private StatsServiceImpl statsService;

    @Test
    void findStats() {

        LOGGER.info("findStats test");

        when(mutantRepository.findStats()).thenReturn(new StatsDto());
        StatsDto statsDto = statsService.findStats();
        assertNotNull(statsDto);

    }

    @Test
    void findStatsNull() {

        LOGGER.info("findStatsNull test");

        when(mutantRepository.findStats()).thenReturn(null);

        try {
            StatsDto statsDto = statsService.findStats();
        } catch (NullPointerException e){
            assertNotNull(e);
        }

    }

}