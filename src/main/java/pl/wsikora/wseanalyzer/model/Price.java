package pl.wsikora.wseanalyzer.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "prices")
public class Price {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

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

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public BigDecimal getLast() {
        return last;
    }

    public void setLast(BigDecimal last) {
        this.last = last;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getPrevious() {
        return previous;
    }

    public void setPrevious(BigDecimal previous) {
        this.previous = previous;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public Long getTradesNumber() {
        return tradesNumber;
    }

    public void setTradesNumber(Long tradesNumber) {
        this.tradesNumber = tradesNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(id, price.id) &&
                Objects.equals(company, price.company) &&
                Objects.equals(datetime, price.datetime) &&
                Objects.equals(last, price.last) &&
                Objects.equals(high, price.high) &&
                Objects.equals(low, price.low) &&
                Objects.equals(open, price.open) &&
                Objects.equals(previous, price.previous) &&
                Objects.equals(volume, price.volume) &&
                Objects.equals(tradesNumber, price.tradesNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, datetime, last, high, low, open, previous, volume, tradesNumber);
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
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
