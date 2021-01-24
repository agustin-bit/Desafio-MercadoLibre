package meli.challenge.demo.service.impl;

import meli.challenge.demo.dto.StatsDto;
import meli.challenge.demo.repository.MutantRepository;
import meli.challenge.demo.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsServiceImpl implements StatsService {

    @Autowired
    private MutantRepository mutantRepository;

    @Override
    public StatsDto findStats() {
        StatsDto statsDto = mutantRepository.findStats();
        float ratio = (float) statsDto.getCountMutantDna() / (float) (statsDto.getCountMutantDna()+statsDto.getCountHumanDna());
        statsDto.setRatio(ratio);
        return statsDto;
    }

}
