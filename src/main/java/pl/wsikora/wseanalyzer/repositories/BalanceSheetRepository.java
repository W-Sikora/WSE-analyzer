package pl.wsikora.wseanalyzer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsikora.wseanalyzer.model.BalanceSheet;

@Repository
public interface BalanceSheetRepository extends JpaRepository<BalanceSheet, Long> {

}
