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
@Table(name = "market_value_ratios")
@JsonDeserialize(builder = MarketValueRatio.Builder.class)
public class MarketValueRatio extends Ratio {

    public MarketValueRatio() {
    }

    @JsonPOJOBuilder
    public static final class Builder {
        private final List<Consumer<MarketValueRatio>> operations;

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

        public MarketValueRatio build() {
            MarketValueRatio marketValueRatio = new MarketValueRatio();
            operations.forEach(operation -> operation.accept(marketValueRatio));
            return marketValueRatio;
        }

    }

    public static Builder builder() {
        return new Builder();
    }

    public MarketValueRatio merge(MarketValueRatio marketValueRatio) {
        return MarketValueRatio.builder()
                .withId(this.id)
                .withCompany(valueChanged(this.company, marketValueRatio.company))
                .withDate(valueChanged(this.date, marketValueRatio.date))
                .withName(valueChanged(this.name, marketValueRatio.name))
                .withShortcut(valueChanged(this.shortcut, marketValueRatio.shortcut))
                .withValue(valueChanged(this.value, marketValueRatio.value))
                .build();
    }

    @Override
    public String toString() {
        return "MarketValueRatio{" +
                "id=" + id +
                ", company=" + company +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", shortcut='" + shortcut + '\'' +
                ", value=" + value +
                '}';
    }
    
}
