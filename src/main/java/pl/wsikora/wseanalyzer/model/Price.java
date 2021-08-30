package pl.wsikora.wseanalyzer.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "prices")
public class Price extends EntityClass {

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "date_time")
    private LocalDateTime datetime;

    private BigDecimal last;

    private BigDecimal high;

    private BigDecimal low;

    private BigDecimal open;

    private BigDecimal previous;

    private Long volume;

    @Column(name = "trades_number")
    private Long tradesNumber;

    public Price() {
    }

    public Company getCompany() {
        return company;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public BigDecimal getLast() {
        return last;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public BigDecimal getPrevious() {
        return previous;
    }

    public Long getVolume() {
        return volume;
    }

    public Long getTradesNumber() {
        return tradesNumber;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public void setLast(BigDecimal last) {
        this.last = last;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public void setPrevious(BigDecimal previous) {
        this.previous = previous;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public void setTradesNumber(Long tradesNumber) {
        this.tradesNumber = tradesNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price that = (Price) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(company, that.company) &&
                Objects.equals(datetime, that.datetime) &&
                Objects.equals(last, that.last) &&
                Objects.equals(high, that.high) &&
                Objects.equals(low, that.low) &&
                Objects.equals(open, that.open) &&
                Objects.equals(previous, that.previous) &&
                Objects.equals(volume, that.volume) &&
                Objects.equals(tradesNumber, that.tradesNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), company, datetime, last, high, low, open, previous, volume, tradesNumber);
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + getId() +
                ", company=" + company +
                ", datetime=" + datetime +
                ", last=" + last +
                ", high=" + high +
                ", low=" + low +
                ", open=" + open +
                ", previous=" + previous +
                ", volume=" + volume +
                ", tradesNumber=" + tradesNumber +
                '}';
    }

}
