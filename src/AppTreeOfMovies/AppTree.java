package AppTreeOfMovies;
import TADMovie.*;
import Tree.*;

import java.io.*;
import java.util.ArrayList;

public class AppTree {
    public static void main(String[] args) throws FileNotFoundException {
        Movies movie1 = new Movies("Public Enemies", 2009, 7.0, 140);
        Movies movie2 = new Movies("American Gangster", 2007, 7.8, 157);
        Movies movie3 = new Movies("Pirates of the Caribbean: Dead Men Tell No Tales", 2017, 6.8, 129);
        Movies movie4 = new Movies("The Dark Knight", 2008, 9.0, 152);
        Movies movie5 = new Movies("The Matrix", 1999, 8.7, 136);
        Movies movie6 = new Movies("Inside Man", 2006, 7.6, 129);
        Movies movie7 = new Movies("The GodFather", 1972, 9.2, 175);
        Movies movie8 = new Movies("Casino Royale", 2006, 8.0, 144);
        Movies movie9 = new Movies("The Last Samurai", 2003, 7.7, 154);
        Movies movie10 = new Movies("Salt", 2010, 6.4, 100);
        Movies movie11 = new Movies("The Lord of the Rings: The Fellowship of the Ring", 2001, 8.8, 178);
        Movies movie12 = new Movies("The Lion King", 1994, 8.5, 98);
        Movies movie13 = new Movies("Shutter Island", 2010, 8.1, 138);
        Movies movie14 = new Movies("Mr. & Mrs. Smith", 2005, 6.5, 120);
        Movies movie15 = new Movies("The Matrix Reloaded", 2003, 7.2, 138);
        Movies movie16 = new Movies("Black Swan", 2010, 8.0, 108);
        Movies movie17 = new Movies("Ocean's Eleven", 2001, 7.8, 116);
        Movies movie18 = new Movies("V for Vendetta", 2005, 8.2, 132);
        System.out.println("Iniciando a árvore vazia");
        BSTree tree = new BSTree(); //Arvore inciada como vazia
        System.out.println("Inserindo filmes na árvore");
        tree.inserir(70, movie1); //Public Enemies
        tree.inserir(80, movie2); //American Gangster
        tree.inserir(60, movie3); //Pirates of Caribbean
        tree.inserir(90, movie4); //The Dark Knight
        tree.inserir(95, movie7); //The Godfather
        tree.inserir(79, movie6); //Inside Man
        tree.inserir(85, movie18); //V for Vendetta
        tree.inserir(87, movie17);//Oceans's Eleven
        System.out.println("Exibindo pre Ordem");
        tree.preOrder(tree.getRoot());
        System.out.println("\nExibindo pós Ordem");
        tree.postOrder(tree.getRoot());
        System.out.println("\nMostrando sucessor");
        System.out.println(tree.sucessor(tree.getRoot()).getMovie());
        System.out.println("\nRemovendo raiz e substituindo raiz pelo seu sucessor");
        tree.removeNode(80);//Removendo raiz, filme American Gangster
        System.out.println("Exibindo pre Ordem");
        tree.preOrder(tree.getRoot());
        System.out.println("\nPesquisando chave 95");
        System.out.println(tree.find(95).getMovie());
        System.out.println("\nInformando altura da árvore");
        System.out.println(tree.altura(tree.getRoot()));
        System.out.println("Teste criando arquivo");

        try {
            tree.inOrder(tree.getRoot(), new PrintStream("myTreeFile.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
