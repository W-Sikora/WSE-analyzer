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
@Table(name = "activity_tags")
@JsonDeserialize(builder = ActivityTag.Builder.class)
public class ActivityTag {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "tag_name", unique = true)
    private String tagName;

    public ActivityTag() {
    }

    public Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    static final class Builder {
        private final List<Consumer<ActivityTag>> operations;

        private Builder() {
            operations = new ArrayList<>();
        }

        public Builder withId(Long id) {
            operations.add(e -> e.id = id);
            return this;
        }

        public Builder withTagName(String tagName) {
            operations.add(e -> e.tagName = tagName);
            return this;
        }

        public ActivityTag build() {
            ActivityTag activityTag = new ActivityTag();
            operations.forEach(operation -> operation.accept(activityTag));
            return activityTag;
        }

    }

    public Long getId() {
        return id;
    }

    public String getTagName() {
        return tagName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityTag that = (ActivityTag) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(tagName, that.tagName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tagName);
    }

    @Override
    public String toString() {
        return "ActivityTag{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                '}';
    }

}
