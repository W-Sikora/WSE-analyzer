package pl.wsikora.wseanalyzer.model;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "shareholders")
public class Shareholder extends EntityClass {

    private String name;

    public Shareholder() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shareholder that = (Shareholder) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name);
    }

    @Override
    public String toString() {
        return "Shareholder{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                '}';
    }

}
