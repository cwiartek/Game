package pl.com.bottega.Drzewo;

public interface TreeNodeVisitor<E> {

    void visit(E element, int level);
}
