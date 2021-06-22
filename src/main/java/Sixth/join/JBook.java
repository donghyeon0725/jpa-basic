package Sixth.join;

import javax.persistence.Entity;

@Entity
public class JBook extends JItem {

    private String author;

    public String getAuthor() {
        return author;
    }

    public JBook setAuthor(String author) {
        this.author = author;
        return this;
    }
}
