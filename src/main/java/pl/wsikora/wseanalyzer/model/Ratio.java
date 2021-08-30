package pl.wsikora.wseanalyzer.model;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@MappedSuperclass
public abstract class Ratio extends EntityClass {

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private LocalDate date;

    private String name;

    private String shortcut;

    private BigDecimal value;

    public Ratio() {
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

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ratio that = (Ratio) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(company, that.company) &&
                Objects.equals(date, that.date) &&
                Objects.equals(name, that.name) &&
                Objects.equals(shortcut, that.shortcut) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), company, date, name, shortcut, value);
    }

    @Override
    public String toString() {
        return "Ratio{" +
                "company=" + company +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", shortcut='" + shortcut + '\'' +
                ", value=" + value +
                '}';
    }

}
