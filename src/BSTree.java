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

    public int height(Node aTree){
        if (aTree == null)
            return 0;
        else
            return (1 + Math.max(height(aTree.getLeft()), height(aTree.getRight())));
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

    public void insert(int aId, Movies x){
        Node temp, current, parent;
        if (getRoot() == null){
            temp = new Node(x, aId);
            setRoot(temp);
            setNoOfNodes(getNoOfNodes()+1);
        } else {
            temp = new Node(x, aId);
            current = getRoot();
            while (true){
                parent = current;
                if (aId < current.getKey()){
                    current = current.getLeft();
                    if (current == null){
                        parent.setLeft(temp);
                        setNoOfNodes(getNoOfNodes()+1);
                        return;
                    }
                }else {
                    current = current.getRight();
                    if (current == null){
                        parent.setRight(temp);
                        setNoOfNodes(getNoOfNodes()+1);
                        return;
                    }
                }
            }
        }
    }

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
