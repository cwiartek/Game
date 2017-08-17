package pl.com.bottega.Drzewo;

public class CategoryTreeApp {

    static int count;

    public static void main(String[] args) {

        TreeNode<String> root = new StandardTreeNode<>("Kategorie");
        TreeNode<String> komputery = new StandardTreeNode<>("Komputery");
        TreeNode<String> smartfony = new StandardTreeNode<>("Smartfony");
        TreeNode<String> tablety = new StandardTreeNode<>("Tablety");
        root.add(komputery);
        root.add(smartfony);
        root.add(tablety);

        TreeNode<String> stacjonarne = new StandardTreeNode<>("Stacjonarne");
        TreeNode<String> laptopy = new StandardTreeNode<>("Laptopy");
        TreeNode<String> podzespoly = new StandardTreeNode<>("Podzespoly");
        komputery.add(stacjonarne);
        komputery.add(laptopy);
        komputery.add(podzespoly);

        TreeNode<String> android = new StandardTreeNode<>("Android");
        TreeNode<String> apple = new StandardTreeNode<>("Apple");
        TreeNode<String> windows = new StandardTreeNode<>("Windows");
        smartfony.add(android);
        smartfony.add(apple);
        smartfony.add(windows);

        //TreePresenter treePresenter = new TreePresenter(root);
        //treePresenter.show();

        TreeWolker<String> walker = new TreeWolker<>(root);
        walker.walk(new TreeNodeVisitor<String>() {
            @Override
            public void visit(String element, int level) {
                System.out.println(space(level)+element);
            }
            private String space (int level) {
                StringBuilder sb = new StringBuilder();
                for ( int i=0; i<level; i++) {
                    sb.append("\t");
                }
                return sb.toString();
            }
        });

        TreeNodeVisitor<String> countingVisitor = new TreeNodeVisitor<String>() {

            @Override
            public void visit(String element, int level) {
                count++;
            }

        };
        walker.walk(countingVisitor);
        System.out.println(count);

    }
}
