package pl.wsikora.wseanalyzer.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "shareholders")
@JsonDeserialize(builder = Shareholder.Builder.class)
public class Shareholder implements ModelEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    public Shareholder() {
    }

    @JsonPOJOBuilder
    public static final class Builder {
        private final List<Consumer<Shareholder>> operations;

        private Builder() {
            operations = new ArrayList<>();
        }

        public Builder withId(Long id) {
            operations.add(e -> e.id = id);
            return this;
        }

        public Builder withName(String name) {
            operations.add(e -> e.name = name);
            return this;
        }

        public Shareholder build() {
            Shareholder shareholder = new Shareholder();
            operations.forEach(operation -> operation.accept(shareholder));
            return shareholder;
        }

    }

    public static Builder builder() {
        return new Builder();
    }

    public Shareholder merge(Shareholder shareholder) {
        return Shareholder.builder()
                .withId(this.id)
                .withName(returnNewValueIfChanged(this.name, shareholder.name))
                .build();
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
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
