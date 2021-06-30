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

    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private LocalDate debutDate;

    private Long sharesNumber;

    private String location;

    private String ceo;

    public CompanyGeneralInfo() {
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

    public Long getSharesNumber() {
        return sharesNumber;
    }

    public void setSharesNumber(Long sharesNumber) {
        this.sharesNumber = sharesNumber;
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


}
