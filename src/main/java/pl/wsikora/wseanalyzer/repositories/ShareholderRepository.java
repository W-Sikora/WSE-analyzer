package pl.wsikora.wseanalyzer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsikora.wseanalyzer.model.Shareholder;

@Repository
public interface ShareholderRepository extends JpaRepository<Shareholder, Long> {

}
