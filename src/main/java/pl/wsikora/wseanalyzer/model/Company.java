package pl.wsikora.wseanalyzer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "companies")
public class Company extends EntityClass {

    @Column(unique = true, length = 180)
    private String name;

    @Column(unique = true, length = 30)
    private String isin;

    @Column(unique = true, length = 5)
    private String ticker;

    @JsonIgnore
    @Column(name = "business_radar_acronym", unique = true, length = 30)
    private String businessRadarAcronym;

    @JsonIgnore
    @Column(name = "banker_acronym", unique = true, length = 30)
    private String bankerAcronym;

    @Deprecated
    public Company() {
    }

    public String getName() {
        return name;
    }

    public String getIsin() {
        return isin;
    }

    public String getTicker() {
        return ticker;
    }

    public String getBusinessRadarAcronym() {
        return businessRadarAcronym;
    }

    public String getBankerAcronym() {
        return bankerAcronym;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setBusinessRadarAcronym(String businessRadarAcronym) {
        this.businessRadarAcronym = businessRadarAcronym;
    }

    public void setBankerAcronym(String bankerAcronym) {
        this.bankerAcronym = bankerAcronym;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company that = (Company) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(name, that.name) &&
                Objects.equals(isin, that.isin) &&
                Objects.equals(ticker, that.ticker) &&
                Objects.equals(businessRadarAcronym, that.businessRadarAcronym) &&
                Objects.equals(bankerAcronym, that.bankerAcronym);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name, isin, ticker, businessRadarAcronym, bankerAcronym);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", isin='" + isin + '\'' +
                ", ticker='" + ticker + '\'' +
                ", businessRadarAcronym='" + businessRadarAcronym + '\'' +
                ", bankerAcronym='" + bankerAcronym + '\'' +
                '}';
    }

}
