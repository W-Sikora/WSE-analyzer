package pl.wsikora.wseanalyzer.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "activity_ratios")
public class ActivityRatio extends Ratio {

    public ActivityRatio() {
    }

    @Override
    public String toString() {
        return super.toString().replaceFirst(super.getClass().getSimpleName(), this.getClass().getSimpleName());
    }

}
