package meli.challenge.demo.model;

import lombok.*;
import meli.challenge.demo.converter.StringListConverter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Mutant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Convert(converter = StringListConverter.class)
    private List<String> dna;
    private boolean isMutant;

}
