package interfaces;

import TADMovie.Movies;
import Tree.Node;

public interface InNode {
    public int getBalance();
    public int getHeight();
    public Node getParent();
    public Movies getMovie();
    public Node getLeft();
    public Node getRight();
    public int getKey();
    public void setMovie(Movies movie);
    public void setLeft(Node left);
    public void setRight(Node right);
    public void setKey(int key);
    public void setParent(Node parent);
    public void setBalance(int balance);
    public void setHeight(int height);
}