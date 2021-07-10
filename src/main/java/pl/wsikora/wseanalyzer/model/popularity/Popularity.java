package pl.wsikora.wseanalyzer.model.popularity;

import pl.wsikora.wseanalyzer.model.company.Company;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "popularities")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Short getBankerRankingPosition() {
        return bankerRankingPosition;
    }

    public void setBankerRankingPosition(Short bankerRankingPosition) {
        this.bankerRankingPosition = bankerRankingPosition;
    }

    public Short getBusinessRadarRankingPosition() {
        return businessRadarRankingPosition;
    }

    public void setBusinessRadarRankingPosition(Short businessRadarRankingPosition) {
        this.businessRadarRankingPosition = businessRadarRankingPosition;
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
