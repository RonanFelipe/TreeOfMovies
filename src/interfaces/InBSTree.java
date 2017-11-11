package interfaces;

import java.io.PrintStream;

import TADMovie.Movies;
import Tree.Node;

    public interface InBSTree {
        public boolean isEmpty();
        public Node getRoot();
        public int getNoOfNodes();
        public void setRoot(Node root);
        public void setNoOfNodes(int noOfNodes);
        public int size(Node aTree);
        public int altura(Node aTree);
        public int alturaEsquerda(Node n);
        public int alturaDireita(Node n);
        public void preOrder(Node aTree);
        public void inOrder(Node aTree, PrintStream print);
        public void postOrder(Node aTree);
        public void inserir(int key, Movies filme);
        public void rebalance(Node atual);
        public Node rotateRight(Node a);
        public Node rotateLeft(Node a);
        public Node doubleRotationLeftRihgt(Node a);
        public Node doubleRotationRightLeft(Node a);
        public void removeNode(int key);
        public Node find(int akey);
        public Node getMinimo(Node aNode);
        public Node getMaximo(Node aNode);
        public Node sucessor(Node aNode);
    }
