package com.bharathkalyans.databasetoexcel.model;


import jakarta.persistence.*;

@Entity
public class UserDetails {


    @Id
    @SequenceGenerator(name = "user_details_generator", sequenceName = "user_details_generator", allocationSize = 1)
    @GeneratedValue(generator = "user_details_generator", strategy = GenerationType.SEQUENCE)
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;


    public UserDetails() {
    }


    public UserDetails(String firstName, String lastName, String email, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

