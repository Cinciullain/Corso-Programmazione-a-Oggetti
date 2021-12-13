/*
    Esercizio: 8.2
    Descrizione: Utilizzando La classe Occorrenza, scrivere un’applicazione che legge un testo da tastiera
    e restituisce una tabella di frequenza delle parole presenti nel testo.
    Suggerimento: per l’input usare la funzionalità copia/incolla per inserire un testo prelevato da un
    documento qualsiasi.
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.utili.Occorrenza;
import prog.utili.Sequenza;

import java.util.Locale;
import java.util.StringTokenizer;

public class Esercizio8_2 {
    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        Sequenza<Occorrenza<String>> tabellaOccorrenze = //Uso sequenza per gestire la tabella di occorrenze
                new Sequenza<>();

        String testo = in.readLine("Inserisci testo: "); //Testo in input
        String parola; //Utilizzato per prendere gestire parola per parola nel testo
        StringTokenizer stk; //Per tokenizzare il testo

        Occorrenza<String> occAttuale; //Occorrenza che si sta prendendo in considerazione al momento
        Occorrenza<String> occTrovata; //Occorrenza all'interno della tabella

        stk = new StringTokenizer(testo, " \t,.;:?!\"");
        while(stk.hasMoreTokens()){
            parola = stk.nextToken().toLowerCase();
            occAttuale = new Occorrenza<>(parola);
            occTrovata = tabellaOccorrenze.find(occAttuale);

            if(occTrovata != null)
                //Se la trova allora incrementa contatore
                occTrovata.incrementa();
            else
                //Altrimenti aggiunge alla tabella
                tabellaOccorrenze.add(occAttuale);
        }

        //Stampo la tabella
        out.println("Tavola delle occorrenze");
        for(Occorrenza<String> o : tabellaOccorrenze)
            out.println("[" + o.toString() + "]");
    }
}
