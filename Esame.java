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

import java.util.Date;

public class Esame {
    private String nomeCorso;
    private Date data;
    private int crediti;
    private int votazione;

    public Esame(String n, int c, int v){
        nomeCorso = n;
        data = new Date();
        crediti = c;
        votazione = v;
    }

    public Esame(String n){
        this(n, 0, 0);
    }

    public String toString(){
        return "Nome corso: " + nomeCorso + "\nData: " + data + "\nCrediti: " + crediti + "\nVotazione: " + votazione;
    }

    public String getNomeCorso() {
        return nomeCorso;
    }

    public Date getData() {
        return data;
    }

    public int getCrediti() {
        return crediti;
    }

    public int getVotazione() {
        return votazione;
    }

//    public boolean equals(Esame altro){
////        if(nomeCorso.equals(altro.getNomeCorso()))
////            if(data.equals(altro.getData()))
////                if(crediti == altro.getCrediti())
////                    if(votazione == altro.getVotazione())
////                        return true;
////        return false;
//        return nomeCorso.equals(altro.getNomeCorso()) && data.equals(altro.getData()) &&
//                crediti == altro.getCrediti() && votazione == altro.getVotazione();
//    }

    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || !(o instanceof Esame)) return false;
        Esame e = (Esame) o;
        return e.nomeCorso.equals(this.nomeCorso) && e.data.equals(this.data) &&
                e.crediti == this.crediti && e.votazione == this.votazione;
    }
}
