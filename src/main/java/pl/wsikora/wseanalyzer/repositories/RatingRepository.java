package pl.wsikora.wseanalyzer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsikora.wseanalyzer.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

}
