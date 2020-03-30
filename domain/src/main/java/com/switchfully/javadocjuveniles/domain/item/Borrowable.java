package com.switchfully.javadocjuveniles.domain.item;

import java.time.LocalDate;

public interface Borrowable {

    String getTitle();
    String getSummary();
    int getNumberOfCopies();
    LocalDate getDateAdded();
    Item setTitle(String title);
    Item setSummary(String summary);
    Item setNumberOfCopies(int numberOfCopies);
    Item setInitialPrice(float initialPrice);
    void toggleAvailability();
    String getDetails();
}
