package meli.challenge.demo.controller;

import meli.challenge.demo.exception.DnaMalformatException;
import meli.challenge.demo.exception.MatrixSizeException;
import meli.challenge.demo.model.Mutant;
import meli.challenge.demo.service.MutantService;
import meli.challenge.demo.validator.DnaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/mutant/")
public class MutantController {

    @Autowired
    private MutantService mutantService;

    @PostMapping
    public ResponseEntity<?> checkMutant(@RequestBody Mutant mutant) throws DnaMalformatException, MatrixSizeException {

        DnaValidator dnaValidator = DnaValidator.getInstance();
        dnaValidator.checkMatrix(mutant.getDna());

        boolean result = mutantService.isMutant(mutant.getDna());

        return ResponseEntity.status(result ? HttpStatus.OK : HttpStatus.FORBIDDEN).body("");

    }

}
