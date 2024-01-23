package it.epicode.week3.gestioneEventiEsG3S3;

import it.epicode.week3.gestioneEventiEsG3S3.dao.EventoDao;

import java.time.LocalDate;

public class UsaEventoDao {

    public static void main(String[] args) {

        EventoDao dao = new EventoDao();
          Evento ev1 = new Evento("Il ritorno di max", LocalDate.of(2024,7,9),"max pezzali-messina(sicilia)-stadio san-filippo",TipoEvento.PUBBLICO, 50000 );
          Evento ev2 = new Evento("Il ritorno di max", LocalDate.of(2024,7,25),"max pezzali-napoli(campania)-stadio maradona",TipoEvento.PUBBLICO, 70000 );
          Evento ev3 = new Evento("Il ritorno di max", LocalDate.of(2024,8,15),"max pezzali- firenze-stadio dallara",TipoEvento.PUBBLICO, 35000 );
          Evento ev4 = new Evento("ligabue", LocalDate.of(2024,6,15),"ligabue- areba di verona",TipoEvento.PUBBLICO, 55000 );





       //dao.saveEvent(ev4);
       //dao.saveEvent(ev3);
       //dao.saveEvent(ev2);
       //dao.saveEvent(ev1);




    }
}
