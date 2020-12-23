package com.example.fitnessapplication;

//for register only
public class Model {

    private int id;
    private String username;
    private String email;
    private String password;
    private String confirmpassword;
    private boolean termofservices;

    public Model(int id, String username, String email, String password, String confirmpassword, boolean termofservice) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmpassword = confirmpassword;
        this.termofservices = termofservice;
    }

    public Model() {
    }

    //toString is necessary for printing the contents of a class object
    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmpassword='" + confirmpassword + '\'' +
                ", termofservices=" + termofservices +
                '}';
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public boolean getTermofservice() {
        return termofservices;
    }

    public void setTermofservice(boolean termofservice) {
        termofservices = termofservice;
    }
}
