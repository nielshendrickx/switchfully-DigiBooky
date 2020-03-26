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
    public Item(String id, String title, String summary, int numberOfCopies, LocalDate dateAdded) {
        this.ID = id;
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
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getSummary() {
        return summary;
    }

    @Override
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
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
