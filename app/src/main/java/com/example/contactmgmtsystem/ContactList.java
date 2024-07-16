package com.example.contactmgmtsystem;

public class ContactList {
    int image;
    String name , number;
    public ContactList(int image , String name , String number)
    {
        this.image = image;
        this.name=name;
        this.number = number;
    }
 public ContactList(String name , String number){
        this.name = name;
        this.number=number;
 }
}
