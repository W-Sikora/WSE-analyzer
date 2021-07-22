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
import static pl.wsikora.wseanalyzer.util.Utils.valueChanged;

@Entity
@Table(name = "shareholdings")
@JsonDeserialize(builder = Shareholding.Builder.class)
public class Shareholding {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "company_id", unique = true)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "shareholder_id")
    private Shareholder shareholder;

    @Column(name = "shares_held")
    private Long sharesHeld;

    @Column(name = "latest_update")
    private LocalDate latestUpdate;

    public Shareholding() {
    }

    @JsonPOJOBuilder
    public static final class Builder {
        private final List<Consumer<Shareholding>> operations;

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

        public Builder withShareholder(Shareholder shareholder) {
            operations.add(e -> e.shareholder = shareholder);
            return this;
        }

        public Builder withSharesHeld(Long sharesHeld) {
            operations.add(e -> e.sharesHeld = sharesHeld);
            return this;
        }

        public Builder withLatestUpdate(LocalDate latestUpdate) {
            operations.add(e -> e.latestUpdate = latestUpdate);
            return this;
        }

        public Shareholding build() {
            Shareholding shareholding = new Shareholding();
            operations.forEach(operation -> operation.accept(shareholding));
            return shareholding;
        }

    }

    public static Builder builder() {
        return new Builder();
    }

    public Shareholding merge(Shareholding shareholding) {
        return Shareholding.builder()
                .withId(this.id)
                .withCompany(valueChanged(this.company, shareholding.company))
                .withShareholder(valueChanged(this.shareholder, shareholding.shareholder))
                .withSharesHeld(valueChanged(this.sharesHeld, shareholding.sharesHeld))
                .withLatestUpdate(valueChanged(this.latestUpdate, shareholding.latestUpdate))
                .build();
    }

    public Long getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    public Shareholder getShareholder() {
        return shareholder;
    }

    public Long getSharesHeld() {
        return sharesHeld;
    }

    public LocalDate getLatestUpdate() {
        return latestUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shareholding that = (Shareholding) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(company, that.company) &&
                Objects.equals(shareholder, that.shareholder) &&
                Objects.equals(sharesHeld, that.sharesHeld) &&
                Objects.equals(latestUpdate, that.latestUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, shareholder, sharesHeld, latestUpdate);
    }

    @Override
    public String toString() {
        return "Shareholding{" +
                "id=" + id +
                ", company=" + company +
                ", shareholder=" + shareholder +
                ", sharesHeld=" + sharesHeld +
                ", latestUpdate=" + latestUpdate +
                '}';
    }

}
