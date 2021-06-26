package pl.wsikora.wseanalyzer.repositories.statement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsikora.wseanalyzer.model.statement.CashFlowStatement;

@Repository
public interface CashFlowStatementRepository extends JpaRepository<CashFlowStatement, Long> {

}
