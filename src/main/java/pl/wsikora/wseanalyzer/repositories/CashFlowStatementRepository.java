package pl.wsikora.wseanalyzer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsikora.wseanalyzer.model.CashFlowStatement;

@Repository
public interface CashFlowStatementRepository extends JpaRepository<CashFlowStatement, Long> {

}
