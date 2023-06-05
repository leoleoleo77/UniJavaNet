package mainpackage.userpackage;

public class ContentAdmin extends User {
    public void insertFilm(int filmId) {
        String tempMessage = String.format("%s added a new film with the Id %s", this.getUsername(),filmId);
        System.out.println(tempMessage);
    }
    public void deleteFilm(int filmId) {
        String tempMessage = String.format("%s deleted the film with Id %s", this.getUsername(), filmId);
        System.out.println(tempMessage);
    }
    public void assignFilmToCinema(int filmId, int cinemaId) {
        String tempMessage = String.format("%s assigned a new film with Id %s, at the cinema with id %s", this.getUsername(), filmId, cinemaId);
        System.out.println(tempMessage);
    }
}
