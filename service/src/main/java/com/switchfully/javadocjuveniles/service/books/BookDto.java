package com.switchfully.javadocjuveniles.service.books;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.switchfully.javadocjuveniles.domain.item.Item;
import com.switchfully.javadocjuveniles.domain.item.book.Author;

import java.time.LocalDate;

public class BookDto extends Item {
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
    @JsonView(View.Public.class)
    private int numberOfCopies;
    @JsonView(View.Restricted.class)
    private double initialPrice;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonView(View.Restricted.class)
    private LocalDate dateAdded;

    @JsonCreator
    public BookDto(@JsonProperty("ID") String ID, @JsonProperty("ISBN") String ISBN, @JsonProperty("author") Author author, @JsonProperty("title") String title, @JsonProperty("summary") String summary
            , @JsonProperty("numberOfCopies") int numberOfCopies, @JsonProperty("date") LocalDate dateAdded, @JsonProperty("initialPrice") double initialPrice) {
        super(title, summary, numberOfCopies, initialPrice);
        this.title = title;
        this.summary = summary;
        this.numberOfCopies = numberOfCopies;
        this.initialPrice = initialPrice;
        this.dateAdded = dateAdded;
        this.ID = ID;
        this.ISBN = ISBN;
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public Author getAuthor() {
        return author;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getSummary() {
        return summary;
    }

    @Override
    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    @Override
    public double getInitialPrice() {
        return initialPrice;
    }

    @Override
    public LocalDate getDateAdded() {
        return dateAdded;
    }
}
