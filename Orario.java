/*
    Capitolo: 7.4
    Descrizione: Semplice esempio d'implementazione di classe

    --------------
    Capitolo 7.7
    Esercizio 7.11
    Descrizione: Implementare l'interfaccia Comparable in questa classe
 */

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Orario implements Comparable<Orario>{
    private int ore, min;
    private static char separatore = ':';
    private static boolean formato24 = true;

    public Orario(int hh, int mm){
        ore = hh;
        min = mm;
    }

    public Orario(String s){
        ore = Integer.parseInt(s.substring(0,2));
        min = Integer.parseInt(s.substring(3,5));
    }

    //Orario attuale
    public Orario(){
        GregorianCalendar adesso = new GregorianCalendar();
        ore = adesso.get(Calendar.HOUR_OF_DAY);
        min = adesso.get(Calendar.MINUTE);
    }

    //Metodi confronto
    public boolean equals(Orario altro){
        return this.ore == altro.ore && this.min == altro.min;
    }

    public boolean isMinore(Orario altro){
        return this.ore < altro.ore || (this.ore == altro.ore && this.min < altro.min);
    }

    public boolean isMaggiore(Orario altro){
        return this.ore > altro.ore || (this.ore == altro.ore && this.min > altro.min);
    }

    //Metodi calcolo
    //Rappresenta i minuti che mancano tra l'orario invocante e quello parametro, in minuti
    public int quantoManca(Orario altro){
        return (altro.ore - ore) * 60 + altro.min - min;
    }

    public String toString(){
        String risultato;
        String stringaMin = (min < 10 ? "0" : "") + min;
        if(formato24)
            risultato = String.valueOf(ore) + separatore + stringaMin;
        else{
            int oraRisultato;
            String suffisso;
            if(ore == 0){
                oraRisultato = 12;
                suffisso = "am";
            } else if(ore > 0 && ore < 12){
                oraRisultato = ore;
                suffisso = "am";
            } else if(ore == 12){
                oraRisultato = 12;
                suffisso = "pm";
            } else{
                oraRisultato = ore - 12;
                suffisso = "pm";
            }
            risultato = String.valueOf(oraRisultato) + separatore + stringaMin + suffisso;
        }
        return risultato;
    }

    //Metodi accesso
    public int getOre(){
        return ore;
    }

    public int getMinuti(){
        return min;
    }

    //Metodi statici
    public static void setFormato24(boolean b){
        formato24 = b;
    }

    public static void  setSeparatoreTo(char ch){
        separatore = ch;
    }

    public static boolean isFormato24Attivo(){
        return formato24;
    }

    public static char getSeparatore(){
        return separatore;
    }

    //Implementazione interfaccia
    public int compareTo(Orario o) {
        if(this.equals(o))
            return 0;
        else
            return 1;
    }
}
