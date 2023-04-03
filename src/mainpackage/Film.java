package mainpackage;

public class Film {
    private int filmId;
    private String filmTitle;
    private String filmCategory;
    private String filmDescription;
    public Film(String filmTitle) {
        this.filmTitle = filmTitle;
        String tempMessage = String.format("created new film called %s", filmTitle);
        System.out.println(tempMessage);
    }

    // Getters Setters
    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public String getFilmCategory() {
        return filmCategory;
    }

    public void setFilmCategory(String filmCategory) {
        this.filmCategory = filmCategory;
    }

    public String getFilmDescription() {
        return filmDescription;
    }

    public void setFilmDescription(String filmDescription) {
        this.filmDescription = filmDescription;
    }
}
