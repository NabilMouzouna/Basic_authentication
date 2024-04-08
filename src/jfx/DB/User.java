package jfx.DB;

public class User {
    static private User instance;
    private int id;
    private String fullname;
    private String email;
    private String password;
    public User(){
        this.id = 0;
        this.fullname = null;
        this.email = null;
        this.password = null;
    }
    public User(int id, String fullname, String email, String password){
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
    }

    // Getter for id
    static public User userInitializer(){
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }

    static public User userInitializer(User user){
        if (instance == null) {
            instance = new User(user.getId(), user.getFullname(), user.getEmail(), user.getPassword());
        }
        return instance;
    }
    
    static public User userInitializer(int id, String fullname, String email, String password){
        if (instance == null) {
            instance = new User(id, fullname, email, password);
        }
        return instance;
    }
    
    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for fullname
    public String getFullname() {
        return fullname;
    }

    // Setter for fullname
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }
    public void showUserInfo(){
        System.out.println("id: " + this.id + " fullname: " + this.fullname + " email: " + this.email + " password: " + this.password);
    }
}
