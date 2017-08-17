package pl.com.bottega.Kolekcje;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList<E> {

    private Link first, last;
    private int lenght;

    @Override
    public void add(E e) {
     /*   Link newLink = new Link();
    //    newLink.element = e;
        if ( first == null) {
            first = newLink;
            last = newLink;
        }
        else {
            last.next = newLink;
            last = newLink;
        }
*/
    }

    @Override
    public void remove(E e) {
        Link l = first;
        Link prev = null;
        while (l !=null) {
            if (l.contains(e)) {
                remove(l, prev);
                return;
            }
            prev = l;
            l = l.next;
        }

    }

    private void remove (Link l , Link prev) {
        if (prev != null && l.next !=null) {
            prev.next = l.next;
        }
        else if (prev ==null && l.next ==null) {
            first = null;
            last = null;
        }
        else if ( prev == null && l.next !=null) {
            first = l.next;
        }
        else {
            prev. next = null;
            last = prev;
        }
        lenght--;
    }

    @Override
    public int length() {
        return lenght;
    }

    @Override
    public void remove(int i) {
        if (i >= 0 && i < lenght) {
            Link l = first;
            Link prev = null;
            int k = 0;

            while(k <i ) {
                prev = l;
                l = l.next;
                k++;
            }
            remove(l, prev);

        }
        else
            throw new ArrayIndexOutOfBoundsException();

    }

    @Override
    public E first() {
        return null;
    }

    @Override
    public E last() {
        return null;
    }

    @Override
    public E get(int i) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            Link currentLink = first;
            @Override
            public boolean hasNext() {

                return currentLink !=null;

            }

            @Override
            public E next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                E tmp = currentLink.e;
                currentLink = currentLink.next;
                return tmp;
            }
        };
    }

    private class Link {
         E e;
         Link next;

         Link (E e) {
             this.e =e;
         }
         boolean contains (E other) {
                 return (e == null && other == null) || e.equals(other);
         }

    }
}
