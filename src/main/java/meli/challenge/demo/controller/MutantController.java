package meli.challenge.demo.controller;

import meli.challenge.demo.dto.MutantDto;
import meli.challenge.demo.exception.DnaMalformatException;
import meli.challenge.demo.exception.MatrixSizeException;
import meli.challenge.demo.model.Mutant;
import meli.challenge.demo.service.MutantService;
import meli.challenge.demo.validator.DnaValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/mutant/")
public class MutantController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MutantController.class.getName());

    @Autowired
    private MutantService mutantService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> checkMutant(@RequestBody MutantDto mutantDto) throws DnaMalformatException, MatrixSizeException {

        DnaValidator dnaValidator = DnaValidator.getInstance();
        dnaValidator.checkMatrix(mutantDto.getDna());

        LOGGER.info("All validations are okey");

        boolean result = mutantService.isMutant(mutantDto.getDna());

        LOGGER.info("The last request is "+result+" for mutant");

        return ResponseEntity.status(result ? HttpStatus.OK : HttpStatus.FORBIDDEN).body("");

    }

}
