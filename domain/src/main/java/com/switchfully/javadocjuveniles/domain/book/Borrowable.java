package com.switchfully.javadocjuveniles.domain.book;

import java.time.LocalDate;

public interface Borrowable {

    String getTitle();
    String getSummary();
    int getNumberOfCopies();
    LocalDate getDateAdded();
    void setTitle(String title);
    void setSummary(String summary);
    void setNumberOfCopies(int numberOfCopies);
    void toggleAvailability();
    String getDetails();
}
