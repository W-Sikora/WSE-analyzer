package pl.wsikora.wseanalyzer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsikora.wseanalyzer.model.IncomeStatement;

@Repository
public interface IncomeStatementRepository extends JpaRepository<IncomeStatement, Long> {

}
