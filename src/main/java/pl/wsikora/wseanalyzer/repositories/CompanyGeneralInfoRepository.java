package pl.wsikora.wseanalyzer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsikora.wseanalyzer.model.CompanyGeneralInfo;

@Repository
public interface CompanyGeneralInfoRepository extends JpaRepository<CompanyGeneralInfo, Long> {

}
