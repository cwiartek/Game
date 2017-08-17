package pl.com.bottega;


public class Box<ContentType> {

    private ContentType element;

    public Box(){}
    public Box(ContentType element) {
        this.element = element;
    }


    public void insert (ContentType element) {
        if (!empty())
            throw new IllegalStateException("Box is not empty");
        this.element = element;

    }

    public ContentType pull(){
        if (empty())
            throw new IllegalStateException("Box is empty");
        ContentType tmp = element;
        element = null;
        return tmp;

    }

    public boolean empty() {
        return element == null;
    }


}
