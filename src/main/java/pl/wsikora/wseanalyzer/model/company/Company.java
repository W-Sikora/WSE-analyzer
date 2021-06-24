package pl.wsikora.wseanalyzer.model.company;

import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String isin;

    private String ticker;

    private String acronym;

    public Company() {
    }

    public Company(String name, String isin, String ticker, String acronym) {
        this.name = name;
        this.isin = isin;
        this.ticker = ticker;
        this.acronym = acronym;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id) &&
                Objects.equals(name, company.name) &&
                Objects.equals(isin, company.isin) &&
                Objects.equals(ticker, company.ticker) &&
                Objects.equals(acronym, company.acronym);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isin, ticker, acronym);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isin='" + isin + '\'' +
                ", ticker='" + ticker + '\'' +
                ", acronym='" + acronym + '\'' +
                '}';
    }

}
