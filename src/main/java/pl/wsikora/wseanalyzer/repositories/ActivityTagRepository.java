package pl.wsikora.wseanalyzer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsikora.wseanalyzer.model.ActivityTag;

@Repository
public interface ActivityTagRepository extends JpaRepository<ActivityTag, Long> {

}
