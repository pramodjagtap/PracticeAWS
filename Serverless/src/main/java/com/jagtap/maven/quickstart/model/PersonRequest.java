package com.jagtap.maven.quickstart.model;

public class PersonRequest {
    private String firstName;
    private String lastName;
    private Integer id;

    public PersonRequest() {
    }

    public PersonRequest(String firstName, String lastName, Integer id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Id=%s, First Name=%s, Last Name=%s", this.getId(), this.getFirstName(),
                this.getLastName());
    }
}
