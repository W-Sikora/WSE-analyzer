package pl.wsikora.wseanalyzer.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static pl.wsikora.wseanalyzer.util.Utils.valueChanged;

@Entity
@Table(name = "ratings")
@JsonDeserialize(builder = Rating.Builder.class)
public class Rating extends Ratio {

    public Rating() {
    }

    @JsonPOJOBuilder
    public static final class Builder {
        private final List<Consumer<Rating>> operations;

        private Builder() {
            operations = new ArrayList<>();
        }

        public Builder withId(Long id) {
            operations.add(e -> e.id = id);
            return this;
        }

        public Builder withCompany(Company company) {
            operations.add(e -> e.company = company);
            return this;
        }

        public Builder withDate(LocalDate date) {
            operations.add(e -> e.date = date);
            return this;
        }

        public Builder withName(String name) {
            operations.add(e -> e.name = name);
            return this;
        }

        public Builder withShortcut(String shortcut) {
            operations.add(e -> e.shortcut = shortcut);
            return this;
        }

        public Builder withValue(BigDecimal value) {
            operations.add(e -> e.value = value);
            return this;
        }

        public Rating build() {
            Rating rating = new Rating();
            operations.forEach(operation -> operation.accept(rating));
            return rating;
        }

    }

    public static Builder builder() {
        return new Builder();
    }

    public Rating merge(Rating rating) {
        return Rating.builder()
                .withId(this.id)
                .withCompany(valueChanged(this.company, rating.company))
                .withDate(valueChanged(this.date, rating.date))
                .withName(valueChanged(this.name, rating.name))
                .withShortcut(valueChanged(this.shortcut, rating.shortcut))
                .withValue(valueChanged(this.value, rating.value))
                .build();
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", company=" + company +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", shortcut='" + shortcut + '\'' +
                ", value=" + value +
                '}';
    }

}
