package pl.wsikora.wseanalyzer.repositories.popularity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsikora.wseanalyzer.model.popularity.Popularity;

@Repository
public interface PopularityRepository extends JpaRepository<Popularity, Long> {

}
