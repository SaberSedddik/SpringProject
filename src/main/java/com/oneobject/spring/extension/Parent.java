package com.oneobject.spring.extension;

import java.util.Map;

/**
 * Created by saberseddik on 15-07-09.
 */
public class Parent {
    private String firstName;
    private String lastName;
    private Map<String,Child> childs;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<String, Child> getChilds() {
        return childs;
    }

    public void setChilds(Map<String, Child> childs) {
        this.childs = childs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parent parent = (Parent) o;

        if (firstName != null ? !firstName.equals(parent.firstName) : parent.firstName != null) return false;
        return !(lastName != null ? !lastName.equals(parent.lastName) : parent.lastName != null);

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
