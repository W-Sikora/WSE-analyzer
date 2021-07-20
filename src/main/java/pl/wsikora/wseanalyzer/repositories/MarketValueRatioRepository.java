package pl.wsikora.wseanalyzer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsikora.wseanalyzer.model.MarketValueRatio;

@Repository
public interface MarketValueRatioRepository extends JpaRepository<MarketValueRatio, Long> {

}
