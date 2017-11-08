package Tree;

import TADMovie.*;

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
            setNoOfNodes(getNoOfNodes() +1);
        } else {
            Node atual = getRoot();
            Node aux;
            while (true){
                aux = atual;
                if (key < atual.getKey()){
                    atual = atual.getLeft();
                    if (atual == null){
                        aux.setLeft(noh);
                        setNoOfNodes(getNoOfNodes() +1);
                        noh.setParent(aux);
                        rebalance(noh.getParent());
                        return;
                    }
                } else {
                    atual = atual.getRight();
                    if (atual == null){
                        aux.setRight(noh);
                        setNoOfNodes(getNoOfNodes() +1);
                        noh.setParent(aux);
                        rebalance(noh.getParent());
                        return;
                    }
                }
            }
        }
    }

    public void rebalance(Node atual){
        int x = alturaDireita(atual);
        int y = alturaEsquerda(atual);
        int z = x-y;
        atual.setBalance(z);
        if (atual.getBalance() == -2){
            if (altura(atual.getLeft().getLeft()) >= altura(atual.getLeft().getRight())){
                atual = rotateRight(atual);
            } else {
                atual = doubleRotationLeftRihgt(atual);
            }
        } else if (atual.getBalance() == 2){
            if (altura(atual.getRight().getRight()) >= altura(atual.getRight().getLeft())){
                atual = rotateLeft(atual);
            } else {
                atual = doubleRotationRightLeft(atual);
            }
        }
        if (atual.getParent() != null){
            rebalance(atual.getParent());
        } else {
            this.root = atual;
        }
        /*if (atual.getBalance() == -1 || atual.getBalance() == 1 || atual.getBalance() == 0 ){
            if (atual.getParent() != null)
            rebalance(atual.getParent());
        } else if (atual.getBalance() < -1 && atual.getLeft() != null && atual.getLeft().getBalance() < 0){//rotação simples direita
            rotateRight(atual);//Lado Esquerdo da árvore
        } else if (atual.getBalance() > 1 && atual.getLeft() != null && atual.getLeft().getBalance() > 0){//rotação simples esquerda
            rotateLeft(atual);//Lado Esquerdo da árvore
        } else if (atual.getBalance() < -1 && atual.getRight() != null && atual.getRight().getBalance() < 0){//rotação simples direita
            rotateRight(atual);//Lado Direito da árvore
        } else if (atual.getBalance() > 1 && atual.getRight() != null && atual.getRight().getBalance() > 0){//rotação simples esquerda
            rotateLeft(atual);//Lado Direito da árvore
        } else if (atual.getBalance() < -1 && atual.getLeft().getBalance() > 0){//sinais opostos, rotação dupla
            doubleRotationLeftRihgt(atual);//rotação simples no filho positivo - Lado Esqurdo da árvore
            //rotação oposta no pai
        } else if (atual.getBalance() > 1 && atual.getLeft().getBalance() < 0){//sinais opostos, rotação dupla
            doubleRotationRightLeft(atual);//rotação simples no filho negativo - Ladoo Esquerdo da árvore
            //rotação oposta no pai
        } else if (atual.getBalance() < -1 && atual.getRight().getBalance() > 0){//sinais opostos, rotação dupla
            doubleRotationLeftRihgt(atual);//rotação simples no filho positivo - Lado Direito da árvore
            //rotação oposta no pai
        } else if (atual.getBalance() > 1 && atual.getRight().getBalance() < 0){//sinais opostos, rotação dupla
            doubleRotationRightLeft(atual);//rotação simples no filho negativo - Lado Direiro da árvore
            //rotação oposta do pai
        }*/

    }

    public Node rotateRight(Node a){
        Node noh = a.getLeft();
        noh.setParent(a.getParent());
        a.setLeft(noh.getRight());
        if (a.getLeft() != null){
            a.getLeft().setParent(a);
        }
        noh.setRight(a);
        a.setParent(noh);
        if (noh.getParent() != null){
            if (noh.getParent().getRight() == a){
                noh.getParent().setRight(noh);
            } else if (noh.getParent().getLeft() == a){
                noh.getParent().setLeft(noh);
            }
        }
        return noh;
    }

    public Node rotateLeft(Node a){
        Node aux = a;
        Node test = aux;
        Node noh = a.getRight();
        noh.setParent(a.getParent());
        a.setRight(noh.getLeft());
        if (a.getRight() != null){
            a.getRight().setParent(a);
        }
        noh.setLeft(a);
        a.setParent(noh);
        if (noh.getParent() != null){
            if (noh.getParent().getRight() == a){
                noh.getParent().setRight(noh);
            } else if (noh.getParent().getLeft() == a){
                noh.getParent().setLeft(noh);
            }
        }
        return noh;
    }

    public Node doubleRotationLeftRihgt(Node a){
        a.setLeft(rotateLeft(a.getLeft()));
        return rotateRight(a);
    }

    public Node doubleRotationRightLeft(Node a){
        a.setRight(rotateRight(a.getRight()));
        return rotateLeft(a);
    }

    public void removeNode(int key){
        if (key == getRoot().getKey()){
            Node aux = getRoot();
            Node test = sucessor(getRoot());
            if (test.getParent() == getRoot()){
                setRoot(test);
                getRoot().setParent(null);
                getRoot().setLeft(aux.getLeft());
                getRoot().getRight().setParent(getRoot());
                getRoot().getLeft().setParent(getRoot());
                setNoOfNodes(getNoOfNodes()-1);
                rebalance(getRoot());
            } else if (test.getRight() != null){
                test.getParent().setLeft(test.getRight());
                setRoot(test);
                getRoot().setParent(null);
                getRoot().setRight(aux.getRight());
                getRoot().setLeft(aux.getLeft());
                getRoot().getRight().setParent(getRoot());
                getRoot().getLeft().setParent(getRoot());
                setNoOfNodes(getNoOfNodes()-1);
                rebalance(test.getRight());
            } else {
                test.getParent().setLeft(null);
                setRoot(test);
                getRoot().setParent(null);
                getRoot().setRight(aux.getRight());
                getRoot().setLeft(aux.getLeft());
                getRoot().getRight().setParent(getRoot());
                getRoot().getLeft().setParent(getRoot());
                setNoOfNodes(getNoOfNodes()-1);
                rebalance(test.getRight());//verificar se test parent é null ou não
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

    /*public Node getSucessor(Node aNode){
        Node current;
        Node sucessor;
        Node sucessorParent;
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

    }*/

    public Node getMinimo(Node aNode){
        while (aNode.getLeft() != null){
            aNode = aNode.getLeft();
        }
        return aNode;
    }

    public Node getMaximo(Node aNode){
        while (aNode.getRight() != null){
            aNode = aNode.getRight();
        }
        return aNode;
    }

    public Node sucessor(Node aNode){
        if (aNode.getRight() != null)
            return getMinimo(aNode.getRight());
        else
            return null;
    }

}
