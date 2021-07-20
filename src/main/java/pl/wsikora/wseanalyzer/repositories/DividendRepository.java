package pl.wsikora.wseanalyzer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsikora.wseanalyzer.model.Dividend;

@Repository
public interface DividendRepository extends JpaRepository<Dividend, Long> {

}
