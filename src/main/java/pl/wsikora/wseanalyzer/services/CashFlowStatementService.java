package pl.wsikora.wseanalyzer.services;


import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.model.CashFlowStatement;

import java.util.List;
import java.util.Optional;

public interface CashFlowStatementService {

    List<CashFlowStatement> getPart(Pageable pageable);

    Optional<CashFlowStatement> getSingle(long id);

    CashFlowStatement create(CashFlowStatement cashFlowStatement);

    CashFlowStatement update(long id, CashFlowStatement cashFlowStatement);

    void delete(long id);

}
