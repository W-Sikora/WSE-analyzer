package pl.wsikora.wseanalyzer.services.company;

import pl.wsikora.wseanalyzer.model.company.general.CompanyGeneralInfo;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface CompanyGeneralInfoService {

    List<CompanyGeneralInfo> getAll(Pageable pageable);

    Optional< CompanyGeneralInfo> getOne(long id);

    void create(CompanyGeneralInfo companyGeneralInfo);

    void update(long id, CompanyGeneralInfo updatedCompanyGeneralInfo);

    void delete(long id);
}
