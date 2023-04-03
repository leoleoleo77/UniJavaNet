package mainpackage;

public class Cinema {
    private int cinemaId;
    private boolean cinema3D;
    private int cinemaNumberOfSeats;
    public Cinema() {
        System.out.println("new cinema created");
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public boolean isCinema3D() {
        return cinema3D;
    }

    public void setCinema3D(boolean cinema3D) {
        this.cinema3D = cinema3D;
    }

    public int getCinemaNumberOfSeats() {
        return cinemaNumberOfSeats;
    }

    public void setCinemaNumberOfSeats(int cinemaNumberOfSeats) {
        this.cinemaNumberOfSeats = cinemaNumberOfSeats;
    }
}
