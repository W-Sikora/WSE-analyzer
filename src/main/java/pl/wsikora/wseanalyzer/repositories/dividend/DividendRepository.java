package pl.wsikora.wseanalyzer.repositories.dividend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsikora.wseanalyzer.model.dividend.Dividend;

@Repository
public interface DividendRepository extends JpaRepository<Dividend, Long> {

}
