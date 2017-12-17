package com.mvp.framework.users.data;


public class ViewModel {

    private String firstName, lastName;
    private String avatar;

    public ViewModel(String firstName, String lastName, String avatar) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAvatar() {
        return avatar;
    }
}
