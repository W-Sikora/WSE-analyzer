package pl.wsikora.wseanalyzer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsikora.wseanalyzer.model.ActivityRatio;

@Repository
public interface ActivityRatioRepository extends JpaRepository<ActivityRatio, Long> {

}
