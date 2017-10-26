public class BSTree {
    private Node root;
    private int NoOfNodes;

    public BSTree() {
        this.root = null;
        NoOfNodes = 0;
    }

    public boolean isEmpty(){
        boolean isVazia = false;
        if (NoOfNodes == 0)
            isVazia = true;
        return isVazia;
    }

    public Node getRoot() {
        return root;
    }

    public int getNoOfNodes() {
        return NoOfNodes;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void setNoOfNodes(int noOfNodes) {
        NoOfNodes = noOfNodes;
    }

    public int size(Node aTree){
        if (aTree == null)
            return 0;
        else
            return (1 + size(aTree.getLeft()) + size(aTree.getRight()));
    }

    public int altura(Node aTree){
        if (aTree == null)
            return -1;
        else
            return (1 + Math.max(altura(aTree.getLeft()), altura(aTree.getRight())));
    }

    public int alturaEsquerda(Node n){
        if (n == null)
            return -1;
        else
            return (1 + (altura(n.getLeft())));
    }

    public int alturaDireita(Node n){
        if (n == null)
            return -1;
        else
            return (1 + (altura(n.getRight())));
    }

    public void preOrder(Node aTree){
        if (aTree != null){
            System.out.println(aTree.getMovie());
            preOrder(aTree.getLeft());
            preOrder(aTree.getRight());
        }
    }

    public void inOrder(Node aTree){
        if (aTree != null){
            inOrder(aTree.getLeft());
            System.out.println(aTree.getMovie());
            inOrder(aTree.getRight());
        }
    }

    public void postOrder(Node aTree){
        if (aTree != null){
            postOrder(aTree.getLeft());
            postOrder(aTree.getRight());
            System.out.println(aTree.getMovie());
        }
    }

    public void inserir(int key, Movies filme){
        Node noh = new Node(filme, key, null);
        if (getRoot() == null){
            setRoot(noh);
        } else {
            Node atual = getRoot();
            Node parent;
            while (true){
                parent = atual;
                if (key < atual.getKey()){
                    atual = atual.getLeft();
                    if (atual == null){
                        parent.setLeft(noh);
                        rebalance(parent);
                        return;
                    }
                } else {
                    atual = atual.getRight();
                    if (atual == null){
                        parent.setRight(noh);
                        rebalance(parent);
                        return;
                    }
                }
            }
        }
    }

    public void rebalance(Node noh){
        int x = alturaDireita(noh);
        int y = alturaEsquerda(noh);
        if (x-y == -2){
            //need to finish
        }

    }

    //public Node rotateRight(Node a){}

    public Node find(int akey){
        Node current = null;
        if (!isEmpty()){
            current = getRoot();
            while (current.getKey() != akey){
                if (akey < current.getKey())
                    current = current.getLeft();
                else
                    current = current.getRight();
                if (current == null)
                    return null;
            }
        }
        return current;
    }

    public Node getSucessor(Node aNode){
        Node current, sucessor, sucessorParent;
        sucessor = aNode;
        sucessorParent = aNode;
        current = aNode.getRight();
        while (current != null){
            sucessorParent = sucessor;
            sucessor = current;
            current = current.getLeft();
        }
        if (sucessor != aNode.getRight()){
            sucessorParent.setLeft(sucessor.getRight());
            sucessor.setRight(aNode.getRight());
        }
        return sucessor;
    }
}
