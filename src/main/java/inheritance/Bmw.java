package inheritance;

import javax.persistence.Entity;

@Entity
public class Bmw extends Car {


    private String series;

    public Bmw(String model, String series) {
        super(model);
        this.series = series;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
}
