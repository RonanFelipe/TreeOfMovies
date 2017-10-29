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
        } else {
            Node atual = getRoot();
            Node parent;
            while (true){
                parent = atual;
                if (key < atual.getKey()){
                    atual = atual.getLeft();
                    if (atual == null){
                        parent.setLeft(noh);
                        rebalance(noh.getParent());
                        return;
                    }
                } else {
                    atual = atual.getRight();
                    if (atual == null){
                        parent.setRight(noh);
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
        atual.setBalance(x-y);
        if (atual.getBalance() == -1 || atual.getBalance() == 1 || atual.getBalance() == 0 ){
            rebalance(atual.getParent());
        } else if (atual.getBalance() < -1 && atual.getLeft().getBalance() < 0){//rotação simples direita
            rotateRight(atual);//Lado Esquerdo da árvore
        } else if (atual.getBalance() > 1 && atual.getLeft().getBalance() > 0){//rotação simples esquerda
            rotateLeft(atual);//Lado Esquerdo da árvore
        } else if (atual.getBalance() < -1 && atual.getRight().getBalance() < 0){//rotação simples direita
            rotateRight(atual);//Lado Direito da árvore
        } else if (atual.getBalance() > 1 && atual.getRight().getBalance() > 0){//rotação simples esquerda
            rotateLeft(atual);//Lado Direito da árvore
        } else if (atual.getBalance() < -1 && atual.getLeft().getBalance() > 0){//sinais opostos, rotação dupla
            rotateLeft(atual.getLeft());//rotação simples no filho positivo - Lado Esqurdo da árvore
            rotateRight(atual);//rotação oposta no pai
        } else if (atual.getBalance() > 1 && atual.getLeft().getBalance() < 0){//sinais opostos, rotação dupla
            rotateRight(atual.getLeft());//rotação simples no filho negativo - Ladoo Esquerdo da árvore
            rotateLeft(atual);//rotação oposta no pai
        } else if (atual.getBalance() < -1 && atual.getRight().getBalance() > 0){//sinais opostos, rotação dupla
            rotateLeft(atual.getRight());//rotação simples no filho positivo - Lado Direito da árvore
            rotateRight(atual);//rotação oposta no pai
        } else if (atual.getBalance() > 1 && atual.getRight().getBalance() < 0){//sinais opostos, rotação dupla
            rotateRight(atual.getRight());//rotação simples no filho negativo - Lado Direiro da árvore
            rotateLeft(atual);//rotação oposta do pai
        }

    }

    public void rotateRight(Node a){
        Node p;
        Node q;
        Node aux;
        p = a;
        q = p.getLeft();
        aux = q.getRight();
        q.setRight(p);
        p.setLeft(aux);
        p = q;
        //Preciso checar se é preciso algum tipo de retorno
    }

    public void rotateLeft(Node a){
        Node p;
        Node q;
        Node aux;
        p = a;
        q = p.getRight();
        aux = q.getLeft();
        q.setLeft(p);
        p.setRight(aux);
        p = q;
        //Preciso checar se é preciso algum tipo de retorno
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
