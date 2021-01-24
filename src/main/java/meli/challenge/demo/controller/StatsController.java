package meli.challenge.demo.controller;

import meli.challenge.demo.dto.StatsDto;
import meli.challenge.demo.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/stats")
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping
    public ResponseEntity<StatsDto> findStats(){
        return ResponseEntity.status(HttpStatus.OK).body(statsService.findStats());
    }

}
