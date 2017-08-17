package pl.com.bottega.Kolekcje;


public interface MyList<E> extends Iterable<E> {


//- dodaje element na koniec listy
    void add(E e);
  //  - usuwa z listy pierwsze wsytąpienie elementu e
    void remove(E e);
    // - zwraca długość listy
    int length();
    //  - usuwa z listy element występujący na pozycji i (i >= 0, i<length())
    void remove(int i);
    // - zwraca pierwszy element listy
    E first();
    // - zwraca ostatni element listy
    E last();
    // - zwraca ostatni element listy
    E get(int i);
}
