package mainpackage;

import mainpackage.userpackage.Admin;
import mainpackage.userpackage.ContentAdmin;
import mainpackage.userpackage.Customer;

public class MainClass {
    public static void main(String[] args) {
        // Customer object example
        Customer customer1 = new Customer();
        customer1.setUsername("leopastreos");
        customer1.login();
        // ContentAdmin object example
        ContentAdmin conAdmin1 = new ContentAdmin();
        conAdmin1.setUsername("foivos666");
        conAdmin1.insertFilm(123);
        // Admin object example
        Admin admin1 = new Admin();
        admin1.setUsername("aggelos4");
        admin1.deleteUser(customer1.getUsername());
        // misc
        Film film1 = new Film("john dick");
        Cinema cinema1 = new Cinema();
        View view1 = new View();

    }
}