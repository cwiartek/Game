package pl.com.bottega.Drzewo;

import java.util.List;

public interface TreeNode<E> {

    // dodaje dziecko do wezla
    void add (TreeNode<E> child);

    // zwraca liste dzieci tego wezla
    List<TreeNode<E>> children();

    // zwraca element przechowywany w tym wezle
    E element();
}
