package meli.challenge.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import meli.challenge.demo.dto.MutantDto;
import meli.challenge.demo.exception.DnaMalformatException;
import meli.challenge.demo.exception.MatrixSizeException;
import meli.challenge.demo.repository.MutantRepository;
import meli.challenge.demo.service.MutantService;
import meli.challenge.demo.service.impl.MutantServiceImpl;
import meli.challenge.demo.service.impl.StatsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = MutantController.class)
class MutantControllerTest {

    private String[] dna = {
            "ATGCGA",
            "CCGTGC",
            "TTATGT",
            "AGAAGG",
            "CCTCCA",
            "TCACTG"
        };

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MutantServiceImpl mutantService;

    @Mock
    private MutantRepository mutantRepository;

    @InjectMocks
    private MutantController mutantController;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void checkMutantFailed() throws Exception {

        MutantDto mutantDto = MutantDto.builder().dna(dna).build();

        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String request = ow.writeValueAsString(mutantDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/mutant/")
                .content(request)
                .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().is(403));


    }

}