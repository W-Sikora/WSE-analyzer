package pl.wsikora.wseanalyzer.model.ratio;

import pl.wsikora.wseanalyzer.model.company.Company;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@MappedSuperclass
public abstract class Ratio {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private LocalDate date;

    private String name;

    private String shortcut;

    private BigDecimal value;

}
