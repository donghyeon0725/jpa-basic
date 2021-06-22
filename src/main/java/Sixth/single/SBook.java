package Sixth.single;

import javax.persistence.Entity;

@Entity
public class SBook extends SItem{
    private String author;

    public String getAuthor() {
        return author;
    }

    public SBook setAuthor(String author) {
        this.author = author;
        return this;
    }
}
