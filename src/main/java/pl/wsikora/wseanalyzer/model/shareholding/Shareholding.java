package pl.wsikora.wseanalyzer.model.shareholding;

import pl.wsikora.wseanalyzer.model.company.Company;

import javax.persistence.*;

import java.time.LocalDate;

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

    private Long sharesHeld;

    private LocalDate updateDate;

    public Shareholding() {
    }

    public Shareholding(Company company, Shareholder shareholder, Long sharesHeld, LocalDate updateDate) {
        this.company = company;
        this.shareholder = shareholder;
        this.sharesHeld = sharesHeld;
        this.updateDate = updateDate;
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

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

}
