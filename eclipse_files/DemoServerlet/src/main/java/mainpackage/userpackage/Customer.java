package mainpackage.userpackage;

public class Customer extends User{
    public void showAvailableFilms() {
        System.out.println("john wick 53");
    }
    public void makeReservation(String Movie) {
        String tempMessage = String.format("Reservation made for the movie %s", Movie);
        System.out.println(tempMessage);
    }
    public void viewReservation() {
        System.out.println("no");
    }
}
