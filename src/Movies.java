public class Movies {
    private String filmeName;
    private int anoFilme;
    private double imdbRating;
    private int minutosDuration;

    public Movies(String filmeName, int anoFilme, double imdbRating, int minutosDuration) {
        setFilmeName(filmeName);
        setAnoFilme(anoFilme);
        setImdbRating(imdbRating);
        setMinutosDuration(minutosDuration);
    }

    public Movies() {
        setFilmeName("Adicionar");
        setAnoFilme(1);
        setImdbRating(0.0);
        setMinutosDuration(0);
    }

    public String getFilmeName() {
        return filmeName;
    }

    public int getAnoFilme() {
        return anoFilme;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public int getMinutosDuration() {
        return minutosDuration;
    }

    public void setFilmeName(String filmeName) {
        this.filmeName = filmeName;
    }

    public void setAnoFilme(int anoFilme) {
        if (anoFilme < 1920)
            this.anoFilme = 1;
        else
            this.anoFilme = anoFilme;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public void setMinutosDuration(int minutosDuration) {
        this.minutosDuration = minutosDuration;
    }

    @Override
    public String toString() {
        return "#Movie Name: " + String.valueOf(getFilmeName()) +
                " Ano:" + String.valueOf(getAnoFilme()) +
                " IMDB Rating: " + String.valueOf(getImdbRating()) +
                " Duration: " + String.valueOf(getMinutosDuration());
    }

}
