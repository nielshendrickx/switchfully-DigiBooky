package com.switchfully.javadocjuveniles.domain.book;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Item implements Borrowable {
    private final String ID;
    private String title;
    private String summary;
    private int numberOfCopies;
    private boolean available;
    private LocalDate dateAdded;
    private float initialPrice;


    public Item(String title, String summary, int numberOfCopies, LocalDate dateAdded) {
        this.ID = UUID.randomUUID().toString();
        this.title = title;
        this.summary = summary;
        this.numberOfCopies = numberOfCopies;
        this.available = true;
        this.dateAdded = dateAdded;
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

    public boolean isAvailable() {
        return available;
    }

    public void toggleAvailability(){
        this.available = !available;
    }

    @Override
    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public float getInitialPrice() {
        return initialPrice;
    }

}
