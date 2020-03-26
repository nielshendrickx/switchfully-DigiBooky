package com.switchfully.javadocjuveniles.domain.book;

import java.util.Date;

public interface Borrowable {

    String getTitle();
    String getSummary();
    int getNumberOfCopies();
    Date getDateAdded();
    void setTitle(String title);
    void setSummary(String summary);
    void setNumberOfCopies(int numberOfCopies);
    void toggleAvailability();
    String getDetails();

}
