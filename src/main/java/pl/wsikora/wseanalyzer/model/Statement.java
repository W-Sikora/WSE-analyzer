package pl.wsikora.wseanalyzer.model;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@MappedSuperclass
public abstract class Statement {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    protected Company company;

    protected LocalDate date;

    public Long getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    public LocalDate getDate() {
        return date;
    }

}
