package pl.wsikora.wseanalyzer.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "companies_general_info")
public class CompanyGeneralInfo extends EntityClass {

    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "debut_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate debutDate;

    @Column(name = "shares_number")
    private Long sharesNumber;

    private String location;

    private String ceo;

    @Column(name = "employees_number")
    private Integer employeesNumber;

    public CompanyGeneralInfo() {
    }

    public Company getCompany() {
        return company;
    }

    public LocalDate getDebutDate() {
        return debutDate;
    }

    public Long getSharesNumber() {
        return sharesNumber;
    }

    public String getLocation() {
        return location;
    }

    public String getCeo() {
        return ceo;
    }

    public Integer getEmployeesNumber() {
        return employeesNumber;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setDebutDate(LocalDate debutDate) {
        this.debutDate = debutDate;
    }

    public void setSharesNumber(Long sharesNumber) {
        this.sharesNumber = sharesNumber;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public void setEmployeesNumber(Integer employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyGeneralInfo that = (CompanyGeneralInfo) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(company, that.company) &&
                Objects.equals(debutDate, that.debutDate) &&
                Objects.equals(sharesNumber, that.sharesNumber) &&
                Objects.equals(location, that.location) &&
                Objects.equals(ceo, that.ceo) &&
                Objects.equals(employeesNumber, that.employeesNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), company, debutDate, sharesNumber, location, ceo, employeesNumber);
    }

    @Override
    public String toString() {
        return "CompanyGeneralInfo{" +
                "id=" + getId() +
                ", company=" + company +
                ", debutDate=" + debutDate +
                ", sharesNumber=" + sharesNumber +
                ", location='" + location + '\'' +
                ", ceo='" + ceo + '\'' +
                ", employeesNumber=" + employeesNumber +
                '}';
    }

}
