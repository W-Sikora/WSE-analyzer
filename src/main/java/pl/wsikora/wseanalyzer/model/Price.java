package pl.wsikora.wseanalyzer.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "prices")
@JsonDeserialize(builder = Price.Builder.class)
public class Price implements ModelEntity {
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

    @JsonPOJOBuilder
    public static final class Builder {
        private final List<Consumer<Price>> operations;

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

        public Builder withDatetime(LocalDateTime datetime) {
            operations.add(e -> e.datetime = datetime);
            return this;
        }

        public Builder withLast(BigDecimal last) {
            operations.add(e -> e.last = last);
            return this;
        }

        public Builder withHigh(BigDecimal high) {
            operations.add(e -> e.high = high);
            return this;
        }

        public Builder withLow(BigDecimal low) {
            operations.add(e -> e.low = low);
            return this;
        }

        public Builder withOpen(BigDecimal open) {
            operations.add(e -> e.open = open);
            return this;
        }

        public Builder withPrevious(BigDecimal previous) {
            operations.add(e -> e.previous = previous);
            return this;
        }

        public Builder withVolume(Long volume) {
            operations.add(e -> e.volume = volume);
            return this;
        }

        public Builder withTradesNumber(Long tradesNumber) {
            operations.add(e -> e.tradesNumber = tradesNumber);
            return this;
        }

        public Price build() {
            Price price = new Price();
            operations.forEach(operation -> operation.accept(price));
            return price;
        }

    }

    public static Builder builder() {
        return new Builder();
    }

    public Price merge(Price price) {
        return Price.builder()
                .withId(this.id)
                .withCompany(returnNewValueIfChanged(this.company, price.company))
                .withDatetime(returnNewValueIfChanged(this.datetime, price.datetime))
                .withLast(returnNewValueIfChanged(this.last, price.last))
                .withHigh(returnNewValueIfChanged(this.high, price.high))
                .withLow(returnNewValueIfChanged(this.low, price.low))
                .withOpen(returnNewValueIfChanged(this.open, price.open))
                .withPrevious(returnNewValueIfChanged(this.previous, price.previous))
                .withVolume(returnNewValueIfChanged(this.volume, price.volume))
                .withTradesNumber(returnNewValueIfChanged(this.tradesNumber, price.tradesNumber))
                .build();
    }

    @Override
    public Long getId() {
        return id;
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
