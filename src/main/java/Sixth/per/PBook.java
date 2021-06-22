package Sixth.per;

import Sixth.join.JBook;

import javax.persistence.Entity;

@Entity
public class PBook extends PItem {
    private String author;

    public String getAuthor() {
        return author;
    }

    public PBook setAuthor(String author) {
        this.author = author;
        return this;
    }
}
