package com.switchfully.javadocjuveniles.domain.book;

import java.time.LocalDate;

public interface Borrowable {

    public String getTitle();
    public String getSummary();
    public int getNumberOfCopies();
    public LocalDate getDateAdded();
    public void setTitle(String title);
    public void setSummary(String summary);
    public void setNumberOfCopies(int numberOfCopies);
    public void toggleAvailability();
    public String getDetails();

}
