/*
    Scrivere un programma come Capitolo6_11, ma per le lettere in una frase
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.io.FileInputManager;
import prog.utili.Occorrenza;
import prog.utili.Sequenza;

import java.util.StringTokenizer;

public class Libro6_19 {

    public static void main(String[] args) {

        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();
        //FileInputManager fileIn = new FileInputManager("C:\\Users\\Cinciullain\\Desktop\\Programmazione\\IntelliJ\\Test\\src\\File.txt");
        //Si può usare un file ma ho usato input da tastiera

        Sequenza<Occorrenza<Character>> tabellaOccorrenze =
                new Sequenza<Occorrenza<Character>>();

        String riga;
        String parola; //Parola estratta da riga
        StringTokenizer stk; //Tokenizer parole riga
        int lunghezzaStringa;

        Occorrenza<Character> nuovaOcc; //Mette le parole delle righe qua
        Occorrenza<Character> occTrovata; //Usa nuovaOcc per cercare nella tavola

        riga = in.readLine("Inserisci riga: ");
        stk = new StringTokenizer(riga, " \t,.;:?!\"'");
        while(stk.hasMoreTokens()){
            parola = stk.nextToken().toLowerCase(); //Prendo uno parola
            lunghezzaStringa = parola.length();

            for(int i = 0; i < lunghezzaStringa; i++){
                nuovaOcc = new Occorrenza<Character>(parola.charAt(i));
                occTrovata = tabellaOccorrenze.find(nuovaOcc);
                if(occTrovata != null)
                    occTrovata.incrementa();
                else
                    tabellaOccorrenze.add(nuovaOcc);
            }
        }

        out.println("Occorrenze: ");
        for(Occorrenza<Character> c : tabellaOccorrenze)
            out.println(c.toString());
    }
}
