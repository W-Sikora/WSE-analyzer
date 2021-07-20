package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.model.DebtRatio;

import java.util.List;
import java.util.Optional;

public interface DebtRatioService {

    List<DebtRatio> getPart(Pageable pageable);

    Optional<DebtRatio> getSingle(long id);

    DebtRatio create(DebtRatio debtRatio);

    DebtRatio update(long id, DebtRatio debtRatio);

    void delete(long id);

}
