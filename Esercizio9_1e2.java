/*
    Esercizio: 9.1
    Descrizione: Modificare l'esercizio 8.2 in modo che il testo venga letto da un
    file indicato dall’utente. A tal fine istanziare un oggetto di tipo FileReader (usare il costruttore che riceve
    il nome del file) con il quale creare un oggetto di tipo BufferedReader. Quest’ultimo rende disponibile il metodo
    readLine() che restituisce la stringa letta o null se è terminato il file (consultare la documentazione di Java).
    La lettura del file avverrà in un ciclo iterativo che termina quando non esistono altre righe da leggere nel file.

 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.utili.Occorrenza;
import prog.utili.Sequenza;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Esercizio9_1e2 {
    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();
        BufferedReader testo;
        try {
            testo = new BufferedReader(new FileReader("C:\\Users\\Cinciullain\\Desktop\\Programmazione\\IntelliJ\\Test\\src\\File.txt"));

            Sequenza<Occorrenza<String>> tabellaOccorrenze = //Uso sequenza per gestire la tabella di occorrenze
                    new Sequenza<>();

            String rigaFile;
            String parola; //Utilizzato per prendere gestire parola per parola nel testo
            StringTokenizer stk; //Per tokenizzare il testo

            Occorrenza<String> occAttuale; //Occorrenza che si sta prendendo in considerazione al momento
            Occorrenza<String> occTrovata; //Occorrenza all'interno della tabella

            while ((rigaFile = testo.readLine()) != null) {
                stk = new StringTokenizer(rigaFile, " \t,.;:?!\"");
                while (stk.hasMoreTokens()) {
                    parola = stk.nextToken().toLowerCase();
                    occAttuale = new Occorrenza<>(parola);
                    occTrovata = tabellaOccorrenze.find(occAttuale);

                    if (occTrovata != null)
                        //Se la trova allora incrementa contatore
                        occTrovata.incrementa();
                    else
                        //Altrimenti aggiunge alla tabella
                        tabellaOccorrenze.add(occAttuale);
                }
            }
            //Stampo la tabella
            out.println("Tavola delle occorrenze");
            for (Occorrenza<String> o : tabellaOccorrenze)
                out.println("[" + o.toString() + "]");
        }catch (FileNotFoundException e) {
            out.println("File non trovato");
        }
        catch (IOException e){
            out.println("Errore IO");
        }
    }
}
