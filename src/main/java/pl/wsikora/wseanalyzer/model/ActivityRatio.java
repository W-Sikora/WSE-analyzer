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
@Table(name = "activity_ratios")
@JsonDeserialize(builder = ActivityRatio.Builder.class)
public class ActivityRatio extends Ratio implements ModelEntity {

    public ActivityRatio() {
    }

    @JsonPOJOBuilder
    public static final class Builder {

        private final List<Consumer<ActivityRatio>> operations;

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

        public ActivityRatio build() {
            ActivityRatio activityRatio = new ActivityRatio();
            operations.forEach(operation -> operation.accept(activityRatio));
            return activityRatio;
        }

    }

    public static Builder builder() {
        return new Builder();
    }

    public ActivityRatio merge(ActivityRatio activityRatio) {
        return ActivityRatio.builder()
                .withId(this.id)
                .withCompany(returnNewValueIfChanged(this.company, activityRatio.company))
                .withDate(returnNewValueIfChanged(this.date, activityRatio.date))
                .withName(returnNewValueIfChanged(this.name, activityRatio.name))
                .withShortcut(returnNewValueIfChanged(this.shortcut, activityRatio.shortcut))
                .withValue(returnNewValueIfChanged(this.value, activityRatio.value))
                .build();
    }

    @Override
    public String toString() {
        return "ActivityRatio{" +
                "id=" + id +
                ", company=" + company +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", shortcut='" + shortcut + '\'' +
                ", value=" + value +
                '}';
    }

}
