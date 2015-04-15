/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.javafxbuch;

public class Person {
       String lastName;
       String firstName;
       int age;
public Person(String firstName, String lastName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
}
       public String getLastName() {
        return lastName;
}
       public String getFirstName() {
        return firstName;
}
       public int getAge() {
        return age;
} }