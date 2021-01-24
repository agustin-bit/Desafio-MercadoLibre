package meli.challenge.demo.repository;

import meli.challenge.demo.dto.StatsDto;
import meli.challenge.demo.model.Mutant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MutantRepository extends JpaRepository<Mutant, Long> {

    @Query(value = "SELECT new meli.challenge.demo.dto.StatsDto(SUM(CASE WHEN (isMutant = TRUE) THEN 1 ELSE 0 END), SUM(CASE WHEN (isMutant = FALSE) THEN 1 ELSE 0 END)) FROM Mutant")
    StatsDto findStats();

}
