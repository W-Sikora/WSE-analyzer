package pl.wsikora.wseanalyzer.model.shareholding;

import javax.persistence.*;

import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "shareholders")
public class Shareholder {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    public Shareholder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Shareholder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
