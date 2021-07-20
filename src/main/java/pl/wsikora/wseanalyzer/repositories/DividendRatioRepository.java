package pl.wsikora.wseanalyzer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsikora.wseanalyzer.model.DividendRatio;

@Repository
public interface DividendRatioRepository extends JpaRepository<DividendRatio, Long> {

}
