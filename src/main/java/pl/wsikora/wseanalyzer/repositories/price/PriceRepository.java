package pl.wsikora.wseanalyzer.repositories.price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsikora.wseanalyzer.model.price.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

}
