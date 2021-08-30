package pl.wsikora.wseanalyzer.model;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
public abstract class Statement extends EntityClass {

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private LocalDate date;

    public Statement() {
    }

    public Company getCompany() {
        return company;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
