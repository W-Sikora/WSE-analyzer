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

@Entity
@Table(name = "dividend_ratios")
@JsonDeserialize(builder = DividendRatio.Builder.class)
public class DividendRatio extends Ratio implements ModelEntity {

    public DividendRatio() {
    }

    @JsonPOJOBuilder
    public static final class Builder {
        private final List<Consumer<DividendRatio>> operations;

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

        public DividendRatio build() {
            DividendRatio dividendRatio = new DividendRatio();
            operations.forEach(operation -> operation.accept(dividendRatio));
            return dividendRatio;
        }

    }

    public static Builder builder() {
        return new Builder();
    }

    public DividendRatio merge(DividendRatio dividendRatio) {
        return DividendRatio.builder()
                .withId(this.id)
                .withCompany(returnNewValueIfChanged(this.company, dividendRatio.company))
                .withDate(returnNewValueIfChanged(this.date, dividendRatio.date))
                .withName(returnNewValueIfChanged(this.name, dividendRatio.name))
                .withShortcut(returnNewValueIfChanged(this.shortcut, dividendRatio.shortcut))
                .withValue(returnNewValueIfChanged(this.value, dividendRatio.value))
                .build();
    }

    @Override
    public String toString() {
        return "DividendRatio{" +
                "id=" + id +
                ", company=" + company +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", shortcut='" + shortcut + '\'' +
                ", value=" + value +
                '}';
    }

}
