package pl.wsikora.wseanalyzer.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "companies_general_info")
@JsonDeserialize(builder = CompanyGeneralInfo.Builder.class)
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

    @Column(name = "employees_number")
    private Integer employeesNumber;

    public CompanyGeneralInfo() {
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    protected static final class Builder {
        private final List<Consumer<CompanyGeneralInfo>> operations;

        private Builder() {
            operations = new ArrayList<>();
        }

        public Builder withId(long id) {
            operations.add(e -> e.id = id);
            return this;
        }

        public Builder withCompany(Company company) {
            operations.add(e -> e.company = company);
            return this;
        }

        public Builder withDebutDate(LocalDate debutDate) {
            operations.add(e -> e.debutDate = debutDate);
            return this;
        }

        public Builder withSharesNumber(long sharesNumber) {
            operations.add(e -> e.sharesNumber = sharesNumber);
            return this;
        }

        public Builder withLocation(String location) {
            operations.add(e -> e.location = location);
            return this;
        }

        public Builder withCeo(String ceo) {
            operations.add(e -> e.ceo = ceo);
            return this;
        }

        public Builder withEmployeesNumber(int employeesNumber) {
            operations.add(e -> e.employeesNumber = employeesNumber);
            return this;
        }

        public CompanyGeneralInfo build() {
            CompanyGeneralInfo companyGeneralInfo = new CompanyGeneralInfo();
            operations.forEach(operation -> operation.accept(companyGeneralInfo));
            return companyGeneralInfo;
        }

    }

    public Long getId() {
        return id;
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
                Objects.equals(ceo, that.ceo) &&
                Objects.equals(employeesNumber, that.employeesNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, debutDate, sharesNumber, location, ceo, employeesNumber);
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
                ", employeesNumber=" + employeesNumber +
                '}';
    }

}
