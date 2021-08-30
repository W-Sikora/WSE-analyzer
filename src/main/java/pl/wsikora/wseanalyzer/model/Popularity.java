package pl.wsikora.wseanalyzer.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "popularities")
public class Popularity extends EntityClass {

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

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setBankerRankingPosition(Short bankerRankingPosition) {
        this.bankerRankingPosition = bankerRankingPosition;
    }

    public void setBusinessRadarRankingPosition(Short businessRadarRankingPosition) {
        this.businessRadarRankingPosition = businessRadarRankingPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Popularity that = (Popularity) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(company, that.company) &&
                Objects.equals(date, that.date) &&
                Objects.equals(bankerRankingPosition, that.bankerRankingPosition) &&
                Objects.equals(businessRadarRankingPosition, that.businessRadarRankingPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), company, date, bankerRankingPosition, businessRadarRankingPosition);
    }

    @Override
    public String toString() {
        return "Popularity{" +
                "id=" + getId() +
                ", company=" + company +
                ", date=" + date +
                ", bankerRankingPosition=" + bankerRankingPosition +
                ", businessRadarRankingPosition=" + businessRadarRankingPosition +
                '}';
    }

}
