package meli.challenge.demo.configuration;

import meli.challenge.demo.service.MutantService;
import meli.challenge.demo.service.StatsService;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@TestConfiguration
public class MockConfiguration {

    @Bean
    @Primary
    public MutantService mutantService(){
        return Mockito.mock(MutantService.class);
    }

    @Bean
    @Primary
    public StatsService statsService(){ return Mockito.mock(StatsService.class); }

}
