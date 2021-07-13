package pl.wsikora.wseanalyzer.dto.company;

import pl.wsikora.wseanalyzer.model.company.Company;

public class CompanyDTO {
    private final long id;
    private final String name;
    private final String isin;
    private final String ticker;

    public CompanyDTO(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.isin = company.getIsin();
        this.ticker = company.getTicker();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIsin() {
        return isin;
    }

    public String getTicker() {
        return ticker;
    }

}
