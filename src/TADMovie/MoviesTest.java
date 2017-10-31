package TADMovie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoviesTest {

    @Test
    public void testImdbRating(){
        Movies x1 = new Movies("A Volta Dos Que Não Foram", 2000, 9.5, 100);
        double result = x1.getImdbRating();
        assertEquals(4.99, result);
    }

    @Test
    public void testAnoMovie(){
        Movies x2 = new Movies("As Belas Tranças do Rei Careca", 1900, 5.0, 100);
        int year = x2.getAnoFilme();
        assertEquals(1950, year);
    }

}