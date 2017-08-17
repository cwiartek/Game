package pl.com.bottega.Kolekcje;

import java.util.*;


public class BookCollections {

    // zwraca książki z kolekcji books które zostały napisane przez zadanego autora
    // NIE modyfikuje kolekcji books!
    public static Collection<Book> findByAuthor(Collection<Book> books, Person author) {
        Collection<Book> authorBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.isAuthor(author))
                authorBooks.add(book);
        }
        return authorBooks;
    }

    // zwraca książki z kolekcji books których tytuł zaczyna się od zadanej frazy,
    // wielkość liter nie ma znaczenia
    // NIE modyfikuje kolekcji books!
    public static Collection<Book> findByTitle(Collection<Book> books, String phrase) {
        Collection<Book> phraseBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.titleStartsWithIgnoreCase(phrase))
                phraseBooks.add(book);
        }
        return phraseBooks;
    }

    // zwraca książki z kolekcji books które należą do wszystkich zadanych gatunków
    // NIE modyfikuje kolekcji books!
    public static Collection<Book> findByGenres(Collection<Book> books, Set<Genre> genres) {
        Collection<Book> genresBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.hasGenres(genres))
                genresBooks.add(book);
        }
        return genresBooks;
    }


    // zwraca posortowaną rosnąco po tytule listę książek stworzoną z kolekcji books
    // NIE modyfikuje kolekcji books!
    public static List<Book> sortByTitle(Collection<Book> books) {
        List<Book> sortedList = new ArrayList<>(books);

        sortedList.sort(new Comparator<Book>() {
            @Override
            public int compare(Book book, Book t1) {
                return book.getTitle().compareTo(t1.getTitle());
            }
        });
        return sortedList;
    }

    // zwraca posortowaną rosnąco listę książek z kolekcji books po nazwisku, imieniu autora i
    // po tytule
    // NIE modyfikuje kolekcji books!
    public static List<Book> sortByAuthorAndTitle(Collection<Book> books) {
        List<Book> sortedList = new ArrayList<>(books);

        sortedList.sort(new Comparator<Book>() {
            @Override
            public int compare(Book book, Book t1) {
                int compareLastName = book.getAuthor().getLastName().compareTo(t1.getAuthor().getLastName());
                if (compareLastName == 0) {
                    int compareFirstName = book.getAuthor().getFirstName().compareTo(t1.getAuthor().getFirstName());
                    if (compareFirstName == 0) {
                        return book.getTitle().compareTo(t1.getTitle());

                    } else
                        return compareFirstName;
                } else
                    return compareLastName;
            }
        });

        return sortedList;
    }

    //tworzy mapę książek należących do poszczególnych gatunków, jeśli ksiżąka należy
    //do wielu gatunków, powinna wiele razy występować na mapie
    public static Map<Genre, Collection<Book>> genresMap(Collection<Book> books) {
        Map<Genre, Collection<Book>> genresBooks = new HashMap<>();

        for (Book book : books) {
            Set<Genre> genres = book.getGenres();

            for (Genre genre : genres) {
                Collection<Book> newBooks;

                if (genresBooks.containsKey(genre)) {
                    newBooks = genresBooks.get(genre);
                } else {
                    newBooks = new HashSet<>();
                }
                newBooks.add(book);
                genresBooks.put(genre, newBooks);
            }
        }

        return genresBooks;
    }

    //tworzy mapę książek należących napisanych przez poszczególnych autorów
    public static Map<Person, Collection<Book>> authorsMap(Collection<Book> books) {
        Map<Person, Collection<Book>> authorBooks = new HashMap<>();

        for (Book book : books) {
            Collection<Book> newBooks;

            if (authorBooks.containsKey(book.getAuthor())) {
                newBooks = authorBooks.get(book.getAuthor());
            } else {
                newBooks = new HashSet<>();
            }
            newBooks.add(book);
            authorBooks.put(book.getAuthor(), newBooks);
        }

        return authorBooks;
    }

    //tworzy mapę z ilością książek napisanych przez zadanego autora
    public static Map<Person, Integer> authorsBookCountMap(Collection<Book> books) {
        Map<Person, Integer> bookMap = new HashMap<>();

        for (Book book : books) {
            Integer currentCount = bookMap.get(book.getAuthor());
            if (currentCount == null)
                bookMap.put(book.getAuthor(), 1);
            else
                bookMap.put(book.getAuthor(), currentCount + 1);
        }
        return bookMap;

    }

    // zwraca liczbę książek których autorem jest auhtor
    public int booksCount(Collection<Book> books, Person author) {
        int bookCounter = 0;

        for (Book book : books) {
            if (book.getAuthor().equals(author))
                bookCounter++;
        }
        return bookCounter;
    }

    // zwraca liczbę książek z danego gatunku
    public int booksCount(Collection<Book> books, Genre genre) {
        int bookCounter = 0;

        for (Book book : books) {
            if (book.hasGenre(genre))
                bookCounter++;
        }
        return bookCounter;
    }

    // zwraca autora który napisał najwięcej książek
    public Person bestAuthor(Collection<Book> books) {
        Map<Person, Integer> autorsBooksCount = authorsBookCountMap(books);
        Integer maxBooks = 0;
        Person maxAuthor = null;

        for (Map.Entry<Person, Integer> entry : autorsBooksCount.entrySet()) {
            if (entry.getValue() > maxBooks)
                maxAuthor = entry.getKey();
        }

        return maxAuthor;
    }

    // zwraca gatunek który ma najwięcej książek
    public Genre mostPopularGenre(Collection<Book> books) {
        Map<Genre, Collection<Book>> genresBooksMap = genresMap(books);
        Integer maxBooks = 0;
        Genre maxGenre = null;

        for (Map.Entry<Genre, Collection<Book>> entry : genresBooksMap.entrySet()) {
            if (entry.getValue().size() > maxBooks)
                maxGenre = entry.getKey();
        }

        return maxGenre;
    }


}





