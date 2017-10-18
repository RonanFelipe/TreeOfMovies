public class Node {
    private Movies movie;
    private Node left;
    private Node right;
    private int key;

    public Node(Movies movie, int key) {
        this.movie = movie;
        this.left = null;
        this.right = null;
        this.key = key;
    }

    public Movies getMovie() {
        return movie;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getKey() {
        return key;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
