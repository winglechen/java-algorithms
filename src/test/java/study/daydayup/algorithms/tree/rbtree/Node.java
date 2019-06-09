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
    private final int DOUBLEBLACK = 2;

    private int key = -1, color = BLACK;
    public Node left=null, right=null, parent=null;

    public Node(int key){
        this.key = key;
    }

    public Node(int key, Node parent) {
        this.key = key;
        this.parent = parent;
    }

    public Node(int key, Node parent, Node left, Node right) {
        this.key = key;
        this.parent = parent;
        this.left = left;
        this.right = right;
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
        this.exchangeChildren();

        Node grandParent = parent.parent;
        parent.parent = this;
        parent = grandParent;
    }

    public boolean isRightChild(){
        return this.equals(parent.right);
    }

    public boolean isLeftChild() {
        return this.equals(parent.left);
    }

    public void levelDown() {

    }

    private void exchangeChildren() {
        if(this.isRightChild()) {
            parent.right = left;
            left = parent;
            return;
        }

        parent.left = right;
        right = parent;
    }
}
