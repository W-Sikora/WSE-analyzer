package pl.wsikora.wseanalyzer.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "market_value_ratios")
public class MarketValueRatio extends Ratio {

    public MarketValueRatio() {
    }

    @Override
    public String toString() {
        return super.toString().replaceFirst(super.getClass().getSimpleName(), this.getClass().getSimpleName());
    }

}
