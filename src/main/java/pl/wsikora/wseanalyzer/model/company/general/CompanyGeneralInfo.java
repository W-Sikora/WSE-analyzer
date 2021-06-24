package pl.wsikora.wseanalyzer.model.company.general;

import pl.wsikora.wseanalyzer.model.company.Company;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "companies_general_info")
public class CompanyGeneralInfo {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private LocalDate debutDate;

    private String location;

    private String ceo;

    public CompanyGeneralInfo() {
    }

    public CompanyGeneralInfo(Company company, LocalDate debutDate, String location, String ceo) {
        this.company = company;
        this.debutDate = debutDate;
        this.location = location;
        this.ceo = ceo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LocalDate getDebutDate() {
        return debutDate;
    }

    public void setDebutDate(LocalDate debutDate) {
        this.debutDate = debutDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyGeneralInfo that = (CompanyGeneralInfo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(company, that.company) &&
                Objects.equals(debutDate, that.debutDate) &&
                Objects.equals(location, that.location) &&
                Objects.equals(ceo, that.ceo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, debutDate, location, ceo);
    }

    @Override
    public String toString() {
        return "CompanyGeneralInfo{" +
                "id=" + id +
                ", company=" + company +
                ", debutDate=" + debutDate +
                ", location='" + location + '\'' +
                ", ceo='" + ceo + '\'' +
                '}';
    }

}
