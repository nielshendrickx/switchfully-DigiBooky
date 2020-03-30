package com.switchfully.javadocjuveniles.service.books;

public class View {
    public interface Public {
    }
    public interface Restricted {
    }
    public interface Summary {
    }
    public interface PublicWithSummary extends Public, Summary{
    }
}
