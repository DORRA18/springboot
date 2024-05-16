package com.example.demo.controllers;

public class RequestData {
	private float effectif;
    private int annee;
    private int depart;
    private int recrutement;

 // Getters
    public float getEffectif() {
        return effectif;
    }

    public int getAnnee() {
        return annee;
    }

    public int getDepart() {
        return depart;
    }

    public int getRecrutement() {
        return recrutement;
    }

    // Setters
    public void setEffectif(float effectif) {
        this.effectif = effectif;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public void setDepart(int depart) {
        this.depart = depart;
    }

    public void setRecrutement(int recrutement) {
        this.recrutement = recrutement;
    }
}
