package com.switchfully.javadocjuveniles.domain.book;

import java.time.LocalDate;

public interface Borrowable {

    String getTitle();
    String getSummary();
    int getNumberOfCopies();
    LocalDate getDateAdded();
    Item setTitle(String title);
    Item setSummary(String summary);
    Item setNumberOfCopies(int numberOfCopies);
    void toggleAvailability();
    String getDetails();
}
