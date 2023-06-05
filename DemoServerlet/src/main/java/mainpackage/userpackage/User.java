package mainpackage.userpackage;

public class User {
    private String name;
    private String username;
    private String password;
    public User() {
        System.out.println("New User created!");
    }
    public void login() {
        String tempMessage = String.format("%s just logged in!", this.username);
        System.out.println(tempMessage);
    }
    public void logout() {
        String tempMessage = String.format("%s just logged out!", this.username);
        System.out.println(tempMessage);
    }

    // Getters Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
