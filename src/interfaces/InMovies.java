package interfaces;

public interface InMovies {
    public String getFilmeName();
    public int getAnoFilme();
    public double getImdbRating();
    public int getMinutosDuration();
    public void setFilmeName(String filmeName);
    public void setAnoFilme(int anoFilme);
    public void setImdbRating(double imdbRating);
    public void setMinutosDuration(int minutosDuration);
    public String toString();
}
