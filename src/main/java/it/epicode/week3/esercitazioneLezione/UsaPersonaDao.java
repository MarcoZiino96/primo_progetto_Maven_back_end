package it.epicode.week3.esercitazioneLezione;

import it.epicode.week3.esercitazioneLezione.dao.PersonaDao;

import java.time.LocalDate;

public class UsaPersonaDao {
    public static void main(String[] args) {
        PersonaDao dao = new PersonaDao();
        Persona p = new Persona();
        p.setCognome("francesco");
        p.setNome("galdi");
        p.setMestiere(Mestiere.COMMERCIALISTA);
        p.setDataNascita(LocalDate.of(2000,5,5));
         dao.inserisciPersona(p);
        System.out.println(p);

        Persona p2= dao.geById(7);
        System.out.println(p2);

        dao.cancellaPersona(7);

    }
}
