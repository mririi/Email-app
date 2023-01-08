package com.example.emailapp;

import java.util.Date;

public class Email {
    private int idE;
    private String objet;
    private String contenu;
    private String envoyepar;
    private Date date;

    public Email(int idE, String objet, String contenu, String envoyepar, Date date) {
        this.idE = idE;
        this.objet = objet;
        this.contenu = contenu;
        this.envoyepar = envoyepar;
        this.date = date;
    }

    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getEnvoyepar() {
        return envoyepar;
    }

    public void setEnvoyepar(String envoyepar) {
        this.envoyepar = envoyepar;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
