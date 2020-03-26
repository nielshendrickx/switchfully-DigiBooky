package com.switchfully.javadocjuveniles.domain.book;

import java.util.Date;
import java.util.UUID;

public abstract class Item implements Borrowable {
    private final String ID;
    private String title;
    private String summary;
    private int numberOfCopies;
    private boolean available;
    private Date dateAdded;
    private float initialPrice;

    protected Item() {
        this.ID = UUID.randomUUID().toString();
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

    public void setAvailable(boolean available) {
        this.available = available;
    }

//    public void toggleAvailability(){
//        if(isAvailable()){
//            available = false;
//        }
//        else
//            available = true;
//    }

    @Override
    public Date getDateAdded() {
        return dateAdded;
    }

    public float getInitialPrice() {
        return initialPrice;
    }

}
