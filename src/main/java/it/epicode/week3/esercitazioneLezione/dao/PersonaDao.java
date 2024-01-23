package it.epicode.week3.esercitazioneLezione.dao;


import it.epicode.week3.esercitazioneLezione.Persona;

import jakarta.persistence.*;

public class PersonaDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public PersonaDao() {
        emf = Persistence.createEntityManagerFactory("epicode_jpa");
        em = emf.createEntityManager();
    }

    public void inserisciPersona(Persona p) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(p);
        et.commit();
        ;
        em.refresh(p);
    }
    public Persona geById(int id){
        return em.find(Persona.class, id);
    }
    public void cancellaPersona(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();
         Persona p = geById(id);
        em.remove(p);
        et.commit();
    }
}
