/*
    Esercizio: 11.1
    Descrizione: Classe prova di carriera
 */

import java.util.Optional;

public class CarrieraProva {
    public static void main(String[] args) {
        Esame e1 = new Esame("P", 10, 20);
        Esame e2 = new Esame("C", 6, 21);
        Esame e3 = new Esame("P", 10, 20);

        System.out.println(e1.toString());
        System.out.println(e3.equals(e1));

        Carriera c = new Carriera(10);
        c.aggiungiEsame("P", 10, 20);
        c.aggiungiEsame(e2);

        for(Esame e: c.getEsami())
            System.out.println(e.toString());


    }
}
