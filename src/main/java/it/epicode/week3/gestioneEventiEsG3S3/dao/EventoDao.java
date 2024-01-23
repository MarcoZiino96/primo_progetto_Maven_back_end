package it.epicode.week3.gestioneEventiEsG3S3.dao;


import it.epicode.week3.gestioneEventiEsG3S3.Evento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventoDao {

    final static Logger infoLogger =  LoggerFactory.getLogger("archivio_info");
    final static Logger errorLogger =  LoggerFactory.getLogger("archivio_error");
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
           infoLogger.info("evento salvato sul databese correttamente");

       }catch (IllegalArgumentException e){
           errorLogger.error(String.valueOf(e));
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
            infoLogger.info("evento cancellato sul databese correttamente");
        }catch (IllegalArgumentException e){
            errorLogger.error(String.valueOf(e));
            em.close();
        }
    }
}
