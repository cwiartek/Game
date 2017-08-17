package pl.com.bottega.Kolekcje;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements MyList<E> {

    private E[] contents;
    private  int count;

    public  MyArrayList() {
        contents = (E[]) new Object[100];
    }
    @Override
    public void add(E e) {
        if(count == contents.length){
            E[] newContents = (E[]) new Object[contents.length + 100];
            System.arraycopy(contents, 0, newContents,0,contents.length);
            contents = newContents;
        }

        contents[count] = e;
        count++;

    }

    @Override
    public void remove(E e) {
        for (int i=0; i<contents.length; i++) {
            if (contents[i].equals(e)) {
                remove(i);
                break;
            }
        }

    }

    @Override
    public int length() {
        return count;
    }

    @Override
    public void remove(int i) {
        if (i>=count || i<0)
            throw new ArrayIndexOutOfBoundsException();
        System.arraycopy(contents, i+1, contents, i, count - i -1);
        contents[count-1] = null;
        count--;

    }

    @Override
    public E first() {
        if (count ==0)
            return null;
        return contents[0];
    }

    @Override
    public E last() {
        if ( count == 0)
            return null;
        return contents[count-1];
    }

    @Override
    public E get(int i) {
        if (i <0 || i >= count)
            throw new ArrayIndexOutOfBoundsException();
        return contents[1];
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            private int currentIndex;

            @Override
            public boolean hasNext() {
                return currentIndex < count;

            }

            @Override
            public E next() {
                if (hasNext())
                    throw new NoSuchElementException();
                return contents[currentIndex++];
            }
        };
    }
}
