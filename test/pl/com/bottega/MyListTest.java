package pl.com.bottega;


import org.junit.jupiter.api.Test;
import pl.com.bottega.Kolekcje.MyArrayList;
import pl.com.bottega.Kolekcje.MyList;

import static org.junit.jupiter.api.Assertions.*;

public class MyListTest {
    @Test
    public void canAddAndRemovedElements() {
        MyList<String> l = new MyArrayList<>();
        l.add("one");
        l.add("two");
        l.add("three");
        l.add("four");
        l.remove("three");
        String four = l.get(2);

        assertEquals("four",four);

    }

    @Test
    public void addingElementShouldChangeSize() {
        MyList<String> l = new MyArrayList<>();
        l.add("one");
        l.add("two");
        l.add("three");
        l.add("four");
        int initialSize = l.length();
        l.add("five");
        assertEquals(true, l.length()>initialSize);
    }
    @Test
    public void removingElementShouldChangeSize() {
        MyList<String> l = new MyArrayList<>();
        l.add("one");
        l.add("two");
        l.add("three");
        l.add("four");
        int initialSize = l.length();
        l.remove("three");
        assertEquals(true, l.length()<initialSize);
    }
    @Test
    public void canAccessElementViaIndex() {
        MyList<String> l = new MyArrayList<>();
        l.add("one");
        l.add("two");
        l.add("three");
        l.add("four");
        assertEquals("two" , l.get(1));
    }
    @Test
    public void canAccessFirstElement() {
        MyList<String> l = new MyArrayList<>();
        l.add("one");
        l.add("two");
        l.add("three");
        l.add("four");
        assertEquals("one" , l.first());
    }
    @Test
    public void canAccessLastElement() {
        MyList<String> l = new MyArrayList<>();
        l.add("one");
        l.add("two");
        l.add("three");
        l.add("four");
        assertEquals("one" , l.last());
    }
    @Test
    public void canStoreNull() {
        MyList<String> l = new MyArrayList<>();
        l.add("one");
        l.add(null);
        assertEquals(null, l.get(1));
    }
    @Test
    public void shouldIterateOverList () {
        MyList<String> l = new MyArrayList<>();
        l.add("one");
        l.add("two");
        l.add("three");

        for (String s : l) {
            System.out.println(s);
        }
    }
}
