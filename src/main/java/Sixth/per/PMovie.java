package Sixth.per;

import javax.persistence.Entity;

@Entity
public class PMovie extends PItem {
    private String director;

    public String getDirector() {
        return director;
    }

    public PMovie setDirector(String director) {
        this.director = director;
        return this;
    }
}
