package pl.wsikora.wseanalyzer.services.company;

import pl.wsikora.wseanalyzer.model.company.CompanyInfo;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface CompanyInfoService {

    List<CompanyInfo> getAll(Pageable pageable);

    Optional<CompanyInfo> getOne(long id);

    void create(CompanyInfo companyInfo);

    void update(long id, CompanyInfo updateCompanyInfo);

    void delete(long id);

}
