package pl.com.bottega.Kolekcje;

import java.util.*;

public class Book {

    private String title;
    private Person author; // klasa Person taka sama jak ta z zajęć
    private Set<Genre> genres = new HashSet<>();

    public Book(String title, Person author, Set<Genre> genres) {
        if (title == null || author == null || genres == null || genres.isEmpty())
            throw new IllegalArgumentException("All data required");
        this.title = title;
        this.author = author;
        this.genres.addAll(genres);
    }

    public boolean hasGenre(Genre genre) {
        return genres.contains(genre);
    }

    public boolean hasGenres(Set<Genre> genres) {
        return genres.containsAll(genres);
    }

    public boolean isAuthor(Person author) {
        return author.equals(author);
    }

    public boolean titleStartsWithIgnoreCase(String phrase) {
        return title.toLowerCase().startsWith(phrase.toLowerCase());
    }

    public String getTitle() {
        return title;
    }

    public Person getAuthor() {
        return author;
    }

    public Set<Genre> getGenres() {
        return genres;
    }


}


