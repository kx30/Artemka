package ru.webant.artemka;

public class User {

    private String imageUrl;
    private String firstName;
    private String lastName;


    public User(String imageUrl, String firstName, String lastName) {
        this.imageUrl = imageUrl;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName + "!";
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}