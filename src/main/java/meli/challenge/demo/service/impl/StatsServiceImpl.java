package meli.challenge.demo.service.impl;

import meli.challenge.demo.dto.StatsDto;
import meli.challenge.demo.repository.MutantRepository;
import meli.challenge.demo.service.StatsService;
import meli.challenge.demo.validator.DnaValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsServiceImpl implements StatsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StatsServiceImpl.class.getName());

    @Autowired
    private MutantRepository mutantRepository;

    @Override
    public StatsDto findStats() {

        LOGGER.info("Start to find the stats of service");

        StatsDto statsDto = mutantRepository.findStats();

        LOGGER.info("Start to calculate ratio");

        float ratio = (float) statsDto.getCountMutantDna() / (float) (statsDto.getCountMutantDna()+statsDto.getCountHumanDna());
        statsDto.setRatio(ratio);

        LOGGER.info("Stats find are concluded successfully");

        return statsDto;
    }

}
