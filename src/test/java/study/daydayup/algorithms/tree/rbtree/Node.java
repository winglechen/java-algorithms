package study.daydayup.algorithms.tree.rbtree;

/**
 * study.daydayup.algorithms.tree.rbtree
 *
 * @author Wingle
 * @since 2019/6/3 8:43 PM
 **/
public class Node {
    private final int BLACK = 0;
    private final int RED = 1;
    private final Node nil = new Node(-1);

    private int key = -1, color = BLACK;
    private Node left, right, parent;

    public Node(int key){
        this.key = key;

        left = nil;
        right = nil;
        parent = nil;
    }

    public void turnRed() {
        if(RED == this.color) {
            return ;
        }

        this.color = RED;
    }

    public void turnBlack() {
        if( BLACK == this.color) {
            return ;
        }

        this.color = BLACK;
    }

    public void turnChildrenBlack() {
        left.turnBlack();
        right.turnBlack();
    }

    public void levelUp() {
        if(BLACK == this.color) {
            return;
        }

        parent = parent.parent;
        this.exchangeChildren();
        parent.parent = this;

        this.turnBlack();
        parent.turnRed();
    }

    private void exchangeChildren() {
        if(this == parent.right) {
            parent.right = left;
            left = parent;
            return;
        }

        parent.left = right;
        right = parent;
    }
}
