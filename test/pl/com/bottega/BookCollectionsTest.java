package pl.com.bottega;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pl.com.bottega.Kolekcje.Book;
import pl.com.bottega.Kolekcje.BookCollections;
import pl.com.bottega.Kolekcje.Genre;
import pl.com.bottega.Kolekcje.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;

public class BookCollectionsTest {

    @Test
    public void shouldReturnTwoBooks() {
        Collection<Book> allBooks = new ArrayList<>();

        Set<Genre> genres = new HashSet<>();
        genres.add(Genre.COMEDY);
        genres.add(Genre.FANTASY);

        Book book1 = new Book("title2", new Person("John", "Doe", 30), genres);
        Book book2 = new Book("title3", new Person("John", "Doe", 30), genres);
        allBooks.add(new Book("title1", new Person("firstname1", "lastname1", 10), genres));
        allBooks.add(book1);
        allBooks.add(book2);

        Person author = new Person("John", "Doe", 30);

        Collection<Book> result = BookCollections.findByAuthor(allBooks, author);

        Assert.assertTrue(result.size() == 2);
        assertThat(result, CoreMatchers.hasItems(book1, book2));
    }
}
