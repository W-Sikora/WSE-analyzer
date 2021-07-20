package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.model.BalanceSheet;

import java.util.List;
import java.util.Optional;

public interface BalanceSheetService {

    List<BalanceSheet> getPart(Pageable pageable);

    Optional<BalanceSheet> getSingle(long id);

    BalanceSheet create(BalanceSheet balanceSheet);

    BalanceSheet update(long id, BalanceSheet balanceSheet);

    void delete(long id);

}
