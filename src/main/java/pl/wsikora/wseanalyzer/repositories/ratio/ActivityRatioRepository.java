package pl.wsikora.wseanalyzer.repositories.ratio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsikora.wseanalyzer.model.ratio.ActivityRatio;

@Repository
public interface ActivityRatioRepository extends JpaRepository<ActivityRatio, Long> {

}
