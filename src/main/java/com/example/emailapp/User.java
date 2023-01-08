package com.example.emailapp;

public class User {
    private int idU;
    private String nomcomplet;
    private String email;
    private String mdp;

    public User(int idU, String nomcomplet, String email, String mdp) {
        this.idU = idU;
        this.nomcomplet = nomcomplet;
        this.email = email;
        this.mdp = mdp;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public String getNomcomplet() {
        return nomcomplet;
    }

    public void setNomcomplet(String nomcomplet) {
        this.nomcomplet = nomcomplet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
