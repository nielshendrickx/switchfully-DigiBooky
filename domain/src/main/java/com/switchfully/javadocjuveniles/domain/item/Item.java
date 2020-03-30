package com.switchfully.javadocjuveniles.domain.item;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Item implements Borrowable {
    private final String ID;
    private String title;
    private String summary;
    private int numberOfCopies;
    private LocalDate dateAdded;
    private float initialPrice;


    public Item(String title, String summary, int numberOfCopies, LocalDate dateAdded, float initialPrice) {
        this.ID = UUID.randomUUID().toString();
        this.title = title;
        this.summary = summary;
        this.numberOfCopies = numberOfCopies;
        this.dateAdded = dateAdded;
        this.initialPrice = initialPrice;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Item setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String getSummary() {
        return summary;
    }

    @Override
    public Item setSummary(String summary) {
        this.summary = summary;
        return this;
    }


    @Override
    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public Item setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
        return this;
    }

    @Override
    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public float getInitialPrice() {
        return initialPrice;
    }

    @Override
    public Item setInitialPrice(float initialPrice) {
        this.initialPrice = initialPrice;
        return this;
    }

}
