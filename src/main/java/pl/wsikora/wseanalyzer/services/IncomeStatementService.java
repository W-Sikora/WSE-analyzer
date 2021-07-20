package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.model.IncomeStatement;

import java.util.List;
import java.util.Optional;

public interface IncomeStatementService {

    List<IncomeStatement> getPart(Pageable pageable);

    Optional<IncomeStatement> getSingle(long id);

    IncomeStatement create(IncomeStatement incomeStatement);

    IncomeStatement update(long id, IncomeStatement incomeStatement);

    void delete(long id);

}
