package mainpackage.userpackage;

public class Admin extends User {
    public void createUser(String username) {
        String tempMessage = String.format("%s created new User with the username %s", this.getUsername(), username);
        System.out.println(tempMessage);
    }
    public void updateUser(String username, String attribute) {
        String tempMessage = String.format("%s Updated the %s of the user %s", this.getUsername(), attribute, username);
        System.out.println(tempMessage);
    }

    public void deleteUser(String username) {
        String tempMessage = String.format("%s Deleted the user %s", this.getUsername(), username);
        System.out.println(tempMessage);
    }

    public void searchUser(String username) {
        String tempMessage = String.format("%s Found the user %s", this.getUsername(), username);
        System.out.println(tempMessage);
    }

    public void viewAllUsers() {
        System.out.println("*");
    }

    public void registerAdmin() {
        System.out.println("registered as admin!");
    }
}
