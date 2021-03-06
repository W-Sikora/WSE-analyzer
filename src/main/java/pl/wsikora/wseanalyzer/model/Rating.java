package pl.wsikora.wseanalyzer.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ratings")
public class Rating extends Ratio {

    public Rating() {
    }

    @Override
    public String toString() {
        return super.toString().replaceFirst(super.getClass().getSimpleName(), this.getClass().getSimpleName());
    }

}
