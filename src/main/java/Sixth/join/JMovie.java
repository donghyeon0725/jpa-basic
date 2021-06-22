package Sixth.join;

import javax.persistence.Entity;

@Entity
public class JMovie extends JItem {
    private String director;

    public String getDirector() {
        return director;
    }

    public JMovie setDirector(String director) {
        this.director = director;
        return this;
    }
}
