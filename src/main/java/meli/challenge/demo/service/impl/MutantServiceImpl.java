package meli.challenge.demo.service.impl;

import meli.challenge.demo.converter.DnaConverter;
import meli.challenge.demo.detector.MutantDetector;
import meli.challenge.demo.service.MutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutantServiceImpl implements MutantService {

    @Autowired
    private MutantDetector mutantDetector;

    @Override
    public boolean isMutant(String[] dna) {

        System.out.println(mutantDetector.check(DnaConverter.stringArrayTo2DCharArray(dna)));

        return false;

    }

}
