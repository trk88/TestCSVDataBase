package by.entity;



public class Entity {

    private String Name;
    private String Surname;
    private String Login;
    private String Email;
    private int Phonenumber;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        Phonenumber = phonenumber;
    }
}
