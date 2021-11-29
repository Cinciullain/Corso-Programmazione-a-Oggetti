/*
    Esercizio: 11.1
    Descrizione: Scrivere una classe Esame che modella l’esame sostenuto da uno studente universitario.
    La classe deve contenere il nome del corso, i crediti, la data e la votazione conseguita. Tutti i campi devono
    essere privati e accessibili solo con opportuni metodi. Quindi scrivere una classe Carriera che tiene conto di
    tutti gli esami (di tipo Esame) sostenuti da uno studente. La classe Carriera deve contenere un campo che si
    riferisce alla matricola dello studente nonché un campo in grado di memorizzare gli oggetti Esame e tutti i metodi
    necessari ad interagire con essa. Inoltre, la classe Carriera deve prevedere metodi in grado di restituire un
    array con tutti gli esami, nonché di calcolare e restituire la media pesata e la media aritmetica attuale.
    Scrivere una classe di test delle classi realizzate.
 */

import java.util.ArrayList;

public class Carriera {
    private int matricola;
    private ArrayList<Esame> esami;

    public Carriera(int m){
        matricola = m;
        esami = new ArrayList<>();
    }

    public int getMatricola() {
        return matricola;
    }

    public ArrayList<Esame> getEsami() {
        return new ArrayList<>(esami);
    }

    public boolean aggiungiEsame(String n, int c, int v){
        Esame e = new Esame(n, c, v);
        if(!esami.contains(e))
            return esami.add(e);
        return false;
    }

    public boolean aggiungiEsame(Esame es){
        Esame e = new Esame(es.getNomeCorso(), es.getCrediti(), es.getVotazione());
        if(!esami.contains(e))
            return esami.add(e);
        return false;
    }

    public boolean annullaEsame(String n, int c, int v){
        return esami.remove(new Esame(n));
    }

    public double mediaAritmetica(){
        if(esami.size() != 0) {
            double m = 0.0;
            for (Esame e : esami)
                m += e.getVotazione();
            return m / esami.size();
        }
        return 0.0;
    }
}
