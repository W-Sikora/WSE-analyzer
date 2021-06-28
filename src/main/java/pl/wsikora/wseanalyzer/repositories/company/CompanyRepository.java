package pl.wsikora.wseanalyzer.repositories.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsikora.wseanalyzer.model.company.Company;

import java.util.Optional;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> getCompanyByTicker(String ticker);

    Optional<Company> getCompanyByIsin(String isin);

    Optional<Company> getCompanyByNameContaining(String name);

}
