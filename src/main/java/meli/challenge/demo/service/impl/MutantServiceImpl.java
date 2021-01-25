package meli.challenge.demo.service.impl;

import meli.challenge.demo.converter.DnaConverter;
import meli.challenge.demo.detector.MutantDetector;
import meli.challenge.demo.model.Mutant;
import meli.challenge.demo.repository.MutantRepository;
import meli.challenge.demo.service.MutantService;
import meli.challenge.demo.validator.DnaValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MutantServiceImpl implements MutantService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MutantServiceImpl.class.getName());

    @Autowired
    private MutantDetector mutantDetector;

    @Autowired
    private MutantRepository mutantRepository;

    @Override
    public boolean isMutant(String[] dna) {

        boolean result = mutantDetector.check(DnaConverter.stringArrayTo2DCharArray(dna));

        Mutant mutant = Mutant.builder().isMutant(result).dna(Arrays.asList(dna)).build();

        LOGGER.info("Start to saving a data in the db");

        mutantRepository.save(mutant);

        LOGGER.info("Data saved successfully");

        return result;

    }

}
