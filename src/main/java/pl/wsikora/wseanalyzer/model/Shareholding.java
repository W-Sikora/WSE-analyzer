package pl.wsikora.wseanalyzer.model;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "shareholdings")
public class Shareholding extends EntityClass {

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

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setShareholder(Shareholder shareholder) {
        this.shareholder = shareholder;
    }

    public void setSharesHeld(Long sharesHeld) {
        this.sharesHeld = sharesHeld;
    }

    public void setLatestUpdate(LocalDate latestUpdate) {
        this.latestUpdate = latestUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shareholding that = (Shareholding) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(company, that.company) &&
                Objects.equals(shareholder, that.shareholder) &&
                Objects.equals(sharesHeld, that.sharesHeld) &&
                Objects.equals(latestUpdate, that.latestUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), company, shareholder, sharesHeld, latestUpdate);
    }

    @Override
    public String toString() {
        return "Shareholding{" +
                "id=" + getId() +
                ", company=" + company +
                ", shareholder=" + shareholder +
                ", sharesHeld=" + sharesHeld +
                ", latestUpdate=" + latestUpdate +
                '}';
    }

}
