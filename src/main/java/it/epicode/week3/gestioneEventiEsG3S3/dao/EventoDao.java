package it.epicode.week3.gestioneEventiEsG3S3.dao;

import it.epicode.week3.esercitazioneLezione.Persona;
import it.epicode.week3.gestioneEventiEsG3S3.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EventoDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public EventoDao(){
        emf = Persistence.createEntityManagerFactory("gestione_eventi");
        em = emf.createEntityManager();
    }

    public Evento getById(int id){
        return em.find(Evento.class, id);
    }

    public void saveEvent(Evento ev){
       try{
           EntityTransaction et = em.getTransaction();
           et.begin();
           em.persist(ev);
           et.commit();
           em.refresh(ev);
       }catch (IllegalArgumentException e){
           e.getMessage();
           em.close();
       }
    }

    public void cancellaEvento(int id){
        try{
            EntityTransaction et = em.getTransaction();
            et.begin();
            Evento ev = getById(id);
            em.remove(ev);
            et.commit();
        }catch (IllegalArgumentException e){
            e.getMessage();
            em.close();
        }
    }
}
