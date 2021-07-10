package pl.wsikora.wseanalyzer.model.company.info;

import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "activity_tags")
public class ActivityTag {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "tag_name")
    private String tagName;

    public ActivityTag() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
