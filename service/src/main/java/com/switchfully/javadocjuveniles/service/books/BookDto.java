package com.switchfully.javadocjuveniles.service.books;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.switchfully.javadocjuveniles.domain.item.book.Author;

import java.time.LocalDate;

public class BookDto {
    @JsonView(View.Public.class)
    private String ID;
    @JsonView(View.Public.class)
    private String ISBN;
    @JsonView(View.Public.class)
    private Author author;
    @JsonView(View.Public.class)
    private String title;
    @JsonView(View.PublicWithSummary.class)
    private String summary;
    @JsonView(View.Restricted.class)
    private int numberOfCopies;
    @JsonView(View.Restricted.class)
    private float initialPrice;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonView(View.Restricted.class)
    private LocalDate dateAdded;

    @JsonCreator
    public BookDto(@JsonProperty("ID") String ID, @JsonProperty("ISBN") String ISBN, @JsonProperty("author") Author author, @JsonProperty("title") String title, @JsonProperty("summary") String summary
            , @JsonProperty("numberOfCopies") int numberOfCopies, @JsonProperty("date") LocalDate dateAdded, @JsonProperty("initialPrice") float initialPrice) {

        this.ID = ID;
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.summary = summary;
        this.numberOfCopies = numberOfCopies;
        this.dateAdded = dateAdded;
        this.initialPrice = initialPrice;
    }


    public String getISBN() {
        return ISBN;
    }

    public Author getAuthor() {
        return author;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public String getID() {
        return ID;
    }

    public float getInitialPrice() {
        return initialPrice;
    }
}
