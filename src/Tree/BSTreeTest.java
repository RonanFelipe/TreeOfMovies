package Tree;

import TADMovie.Movies;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTreeTest {

    @Test
    public void testNumOfNodes(){
        Movies x1 = new Movies("A Volta Dos Que Não Foram", 2000, 9.5, 100);
        BSTree tree = new BSTree();
        tree.inserir(5, x1);
        int result = tree.getNoOfNodes();
        assertEquals(1, result);
    }

    @Test
    public void testAlturaDir(){
        Movies x1 = new Movies("A Volta Dos Que Não Foram", 2000, 9.5, 100);
        BSTree tree = new BSTree();
        tree.inserir(5, x1);
        Node noh = tree.getRoot();
        int altura = tree.alturaDireita(noh);
        assertEquals(0, altura);
    }

    @Test
    public void testAlturaEsq(){
        Movies x1 = new Movies("A Volta Dos Que Não Foram", 2000, 9.5, 100);
        BSTree tree = new BSTree();
        tree.inserir(5, x1);
        Node noh = tree.getRoot();
        int altura = tree.alturaEsquerda(noh);
        assertEquals(0, altura);
    }

    @Test
    public void testAltura(){
        Movies x1 = new Movies("A Volta Dos Que Não Foram", 2000, 9.5, 100);
        BSTree tree = new BSTree();
        tree.inserir(5, x1);
        Node noh = tree.getRoot();
        int altura = tree.altura(noh);
        assertEquals(0, altura);
    }

    @Test
    public void testIsEmpty(){
        Movies x1 = new Movies("A Volta Dos Que Não Foram", 2000, 9.5, 100);
        BSTree tree = new BSTree();
        tree.inserir(5, x1);
        boolean result = tree.isEmpty();
        assertEquals(false, result);
    }

    /*@Test
    public void testSize(){
        Movies x1 = new Movies("A Volta Dos Que Não Foram", 2000, 9.5, 100);
        Movies x2 = new Movies("As Belas Tranças do Rei Careca", 1900, 5.0, 100);
        BSTree tree = new BSTree();
        tree.inserir(5, x1);
        tree.inserir(1, x2);
        Node noh = tree.getRoot();
        int tam = tree.size(noh);
        assertEquals(1, tam);

    }*/

    @Test
    public void testInsert2Nodes(){
        BSTree tree = new BSTree();
        Movies x2 = new Movies("As Belas Tranças do Rei Careca", 1900, 5.0, 100);
        Movies x1 = new Movies("A Volta Dos Que Não Foram", 1900, 5.0, 100);
        tree.inserir(2, x2);
        tree.inserir(3, x1);
        int result = tree.getNoOfNodes();
        assertEquals(2, result);
    }


}