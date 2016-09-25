package org.abondar.experimental.homelessHack.model;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by alexabon on 9/24/2016.
 */
public class Case {
    private int id;
    private int goodWeight;
    private LocalDate pubDate;
    private LocalDate expDate;
    private Organization grocery;
    private Good good;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodWeight() {
        return goodWeight;
    }

    public void setGoodWeight(int goodWeight) {
        this.goodWeight = goodWeight;
    }

    public LocalDate getPubDate() {
        return pubDate;
    }

    public void setPubDate(LocalDate pubDate) {
        this.pubDate = pubDate;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public Organization getGrocery() {
        return grocery;
    }

    public void setGrocery(Organization grocery) {
        this.grocery = grocery;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    @Override
    public String toString() {
        return "Case{" +
                "id=" + id +
                ", goodWeight=" + goodWeight +
                ", pubDate=" + pubDate +
                ", expDate=" + expDate +
                ", grocery=" + grocery +
                ", good=" + good +
                '}';
    }
}
