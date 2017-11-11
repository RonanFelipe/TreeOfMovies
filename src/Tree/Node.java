package Tree;

import Abstracts.ABSNode;
import TADMovie.*;


public class Node extends ABSNode {


    public Node(Movies movie, int key, Node parent) {
        this.movie = movie;
        this.left = null;
        this.right = null;
        this.parent = parent;
        this.key = key;
        this.balance = 0;
        this.height = 0;
    }

    public int getBalance() {
        return balance;
    }

    public int getHeight() {
        return height;
    }

    public Node getParent() {
        return parent;
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

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
