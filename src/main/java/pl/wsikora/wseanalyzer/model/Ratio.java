package pl.wsikora.wseanalyzer.model;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@MappedSuperclass
public abstract class Ratio {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    protected Company company;

    protected LocalDate date;

    protected String name;

    protected String shortcut;

    protected BigDecimal value;

    public Long getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getShortcut() {
        return shortcut;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ratio ratio = (Ratio) o;
        return Objects.equals(id, ratio.id) &&
                Objects.equals(company, ratio.company) &&
                Objects.equals(date, ratio.date) &&
                Objects.equals(name, ratio.name) &&
                Objects.equals(shortcut, ratio.shortcut) &&
                Objects.equals(value, ratio.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, date, name, shortcut, value);
    }

}
