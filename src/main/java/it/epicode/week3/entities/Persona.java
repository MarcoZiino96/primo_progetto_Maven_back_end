package it.epicode.week3.entities;


import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "persona")

public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String cognome;

    @Column(name = "data_nascita",nullable = false)
    private LocalDate dataNascita;

    @Enumerated(EnumType.STRING)
    private Mestiere mestiere;

    public Persona(int id, String nome, String cognome, LocalDate dataNascita, Mestiere mestiere) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.mestiere = mestiere;
    }

    public Persona(String nome, String cognome, LocalDate dataNascita, Mestiere mestiere) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.mestiere = mestiere;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public Mestiere getMestiere() {
        return mestiere;
    }

    public void setMestiere(Mestiere mestiere) {
        this.mestiere = mestiere;
    }



    public Persona(){

    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                ", mestiere=" + mestiere +
                '}';
    }



}
