package Abstracts;

import interfaces.InNode;
import TADMovie.Movies;
import Tree.Node;

public abstract class ABSNode implements InNode {
    protected Movies movie;
    protected Node left;
    protected Node right;
    protected Node parent;
    protected int key;
    protected int balance;
    protected int height;
}
