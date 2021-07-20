package pl.wsikora.wseanalyzer.model;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "shareholdings")
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

    public Shareholder getShareholder() {
        return shareholder;
    }

    public void setShareholder(Shareholder shareholder) {
        this.shareholder = shareholder;
    }

    public Long getSharesHeld() {
        return sharesHeld;
    }

    public void setSharesHeld(Long sharesHeld) {
        this.sharesHeld = sharesHeld;
    }

    public LocalDate getLatestUpdate() {
        return latestUpdate;
    }

    public void setLatestUpdate(LocalDate updateDate) {
        this.latestUpdate = updateDate;
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
