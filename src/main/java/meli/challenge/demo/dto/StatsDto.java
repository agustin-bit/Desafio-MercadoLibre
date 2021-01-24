package meli.challenge.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class StatsDto {

    public StatsDto(){

    }

    public StatsDto(long countMutantDna, long countHumanDna){
        this.countHumanDna = countHumanDna;
        this.countMutantDna = countMutantDna;
    }

    @JsonProperty("count_mutant_dna")
    private long countMutantDna;
    @JsonProperty("count_human_dna")
    private long countHumanDna;
    private float ratio;

}
