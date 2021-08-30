package pl.wsikora.wseanalyzer.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "activity_tags")
public class ActivityTag extends EntityClass {

    @Column(name = "tag_name", unique = true)
    private String tagName;

    public ActivityTag() {
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityTag that = (ActivityTag) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(tagName, that.tagName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), tagName);
    }

    @Override
    public String toString() {
        return "ActivityTag{" +
                "id=" + getId() +
                ", tagName='" + tagName + '\'' +
                '}';
    }

}
