package pl.wsikora.wseanalyzer.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "debt_ratios")
public class DebtRatio extends Ratio {

    @Deprecated
    public DebtRatio() {
    }

    @Override
    public String toString() {
        return super.toString().replaceFirst(super.getClass().getSimpleName(), this.getClass().getSimpleName());
    }

}
