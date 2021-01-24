package meli.challenge.demo.service.impl;

import meli.challenge.demo.dto.StatsDto;
import meli.challenge.demo.repository.MutantRepository;
import meli.challenge.demo.service.StatsService;
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
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StatsServiceImplTest {

    @Mock
    private MutantRepository mutantRepository;

    @InjectMocks
    private StatsServiceImpl statsService;

    @Test
    void findStats() {

        when(mutantRepository.findStats()).thenReturn(new StatsDto());
        StatsDto statsDto = statsService.findStats();
        assertNotNull(statsDto);

    }

}