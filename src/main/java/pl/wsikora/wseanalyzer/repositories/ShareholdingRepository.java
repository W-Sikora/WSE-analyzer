package pl.wsikora.wseanalyzer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsikora.wseanalyzer.model.Shareholding;

@Repository
public interface ShareholdingRepository extends JpaRepository<Shareholding, Long> {

}
