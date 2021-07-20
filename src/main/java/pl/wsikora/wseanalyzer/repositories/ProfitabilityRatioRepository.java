package pl.wsikora.wseanalyzer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsikora.wseanalyzer.model.ProfitabilityRatio;

@Repository
public interface ProfitabilityRatioRepository extends JpaRepository<ProfitabilityRatio, Long> {

}
