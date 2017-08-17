package pl.com.bottega;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class BoxTest {

    private Box nonEmptyBox = new Box("test");

    @Test
    public void canCreateNonEmptyBox() {
        Box box = new Box("test");

        assertFalse(nonEmptyBox.empty());
    }

    @Test
    public void canCreateEmptyBox() {
        Box box = new Box();

        assertTrue(box.empty());
    }

    @Test
    public void pullsElementFromTheBox() {
        Box box = new Box("test");

        String pulledElement = (String) nonEmptyBox.pull();
        assertEquals("test", pulledElement);
    }

    @Test
    public void boxIsEmptyAfterPull() {
        nonEmptyBox.pull();
        assertTrue(nonEmptyBox.empty());
    }

    @Test
    public void canInsertAndPullElement() {
        //given
        Box box = new Box();
        //when
        box.insert("test");
        String pulledElement = (String) box.pull();
        //then
        assertEquals("test", pulledElement);
    }

    @Test
    public void ThrowsThenInsertingToNonEmptyBox() {
        assertThrows(IllegalStateException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                nonEmptyBox.insert("Something else");
            }
        });
    }


      //  try {
      //      nonEmptyBox.insert("Something else");
      //      fail ("Should throw exception");
      //  } catch (IllegalStateException ex) {
      //      assertEquals("Box is not empty", ex.getMessage());
      //  }


    @Test
    public void ThrowsWhenPullingFromEmptyBox() {
        assertThrows(IllegalStateException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new Box().pull();
            }
        });

    }

    class PullFromEmptyBox implements Executable {

        @Override
        public void execute() throws Throwable {
            new Box().pull();
        }
    }
    @Test
    public void canHoldIntegers() {
        Box<Integer> IntegerBox = new Box<>();

        IntegerBox.insert(666);

        Integer pulledInteger = IntegerBox.pull();
        assertEquals(new Integer(666), pulledInteger);
    }
}
