package pl.wsikora.wseanalyzer.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "popularities")
@JsonDeserialize(builder = Popularity.Builder.class)
public class Popularity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private LocalDate date;

    @Column(name = "banker_ranking_position")
    private Short bankerRankingPosition;

    @Column(name = "business_radar_ranking_position")
    private Short businessRadarRankingPosition;

    public Popularity() {
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    static final class Builder {
        private final List<Consumer<Popularity>> operations;

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

        public Builder withBankerRankingPosition(Short bankerRankingPosition) {
            operations.add(e -> e.bankerRankingPosition = bankerRankingPosition);
            return this;
        }

        public Builder withBusinessRadarRankingPosition(Short businessRadarRankingPosition) {
            operations.add(e -> e.businessRadarRankingPosition = businessRadarRankingPosition);
            return this;
        }

        public Popularity build() {
            Popularity popularity = new Popularity();
            operations.forEach(operation -> operation.accept(popularity));
            return popularity;
        }

    }

    public Long getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    public LocalDate getDate() {
        return date;
    }

    public Short getBankerRankingPosition() {
        return bankerRankingPosition;
    }

    public Short getBusinessRadarRankingPosition() {
        return businessRadarRankingPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Popularity that = (Popularity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(company, that.company) &&
                Objects.equals(date, that.date) &&
                Objects.equals(bankerRankingPosition, that.bankerRankingPosition) &&
                Objects.equals(businessRadarRankingPosition, that.businessRadarRankingPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, date, bankerRankingPosition, businessRadarRankingPosition);
    }

    @Override
    public String toString() {
        return "Popularity{" +
                "id=" + id +
                ", company=" + company +
                ", date=" + date +
                ", bankerRankingPosition=" + bankerRankingPosition +
                ", businessRadarRankingPosition=" + businessRadarRankingPosition +
                '}';
    }

}
