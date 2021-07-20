package pl.wsikora.wseanalyzer.model;

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

    @Column(name = "debut_date")
    private LocalDate debutDate;

    @Column(name = "shares_number")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyGeneralInfo that = (CompanyGeneralInfo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(company, that.company) &&
                Objects.equals(debutDate, that.debutDate) &&
                Objects.equals(sharesNumber, that.sharesNumber) &&
                Objects.equals(location, that.location) &&
                Objects.equals(ceo, that.ceo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, debutDate, sharesNumber, location, ceo);
    }

    @Override
    public String toString() {
        return "CompanyGeneralInfo{" +
                "id=" + id +
                ", company=" + company +
                ", debutDate=" + debutDate +
                ", sharesNumber=" + sharesNumber +
                ", location='" + location + '\'' +
                ", ceo='" + ceo + '\'' +
                '}';
    }

}
