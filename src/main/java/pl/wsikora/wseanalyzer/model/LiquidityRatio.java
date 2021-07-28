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
@Table(name = "liquidity_ratios")
@JsonDeserialize(builder = LiquidityRatio.Builder.class)
public class LiquidityRatio extends Ratio implements ModelEntity {

    public LiquidityRatio() {
    }

    @JsonPOJOBuilder
    public static final class Builder {
        private final List<Consumer<LiquidityRatio>> operations;

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

        public LiquidityRatio build() {
            LiquidityRatio liquidityRatio = new LiquidityRatio();
            operations.forEach(operation -> operation.accept(liquidityRatio));
            return liquidityRatio;
        }

    }

    public static Builder builder() {
        return new Builder();
    }

    public LiquidityRatio merge(LiquidityRatio liquidityRatio) {
        return LiquidityRatio.builder()
                .withId(this.id)
                .withCompany(returnNewValueIfChanged(this.company, liquidityRatio.company))
                .withDate(returnNewValueIfChanged(this.date, liquidityRatio.date))
                .withName(returnNewValueIfChanged(this.name, liquidityRatio.name))
                .withShortcut(returnNewValueIfChanged(this.shortcut, liquidityRatio.shortcut))
                .withValue(returnNewValueIfChanged(this.value, liquidityRatio.value))
                .build();
    }

    @Override
    public String toString() {
        return "LiquidityRatio{" +
                "id=" + id +
                ", company=" + company +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", shortcut='" + shortcut + '\'' +
                ", value=" + value +
                '}';
    }
    
}
