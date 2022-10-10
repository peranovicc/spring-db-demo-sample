package com.example.demo_db.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    private String ime;
    private String prezime;
    private int id;

    public Student() {
    }

    public Student(String ime, String prezime, int id) {
        this.ime = ime;
        this.prezime = prezime;
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", id=" + id +
                '}';
    }
}
