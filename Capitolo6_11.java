/*
    Leggere un file di testo e produrre in output un elenco delle parole
    che compaiono nel file, indicando, per ognuna, il numero di occorrenze
 */

import prog.io.ConsoleOutputManager;
import prog.io.FileInputManager;
import prog.utili.Occorrenza;
import prog.utili.Sequenza;

import java.util.Locale;
import java.util.StringTokenizer;

public class Capitolo6_11 {

    public static void main(String[] args) {

        ConsoleOutputManager out = new ConsoleOutputManager();
        //FileInputManager fileIn = new FileInputManager(args[0]); per file da riga da comando
        FileInputManager fileIn = new FileInputManager("C:\\Users\\Cinciullain\\Desktop\\Programmazione\\IntelliJ\\Test\\src\\File.txt");

        Sequenza<Occorrenza<String>> tavolaOccorrenze =
                new Sequenza<Occorrenza<String>>();

        String rigaFile; //Riga file
        String parola; //Parola estratta da riga
        StringTokenizer stk; //Tokenizer parole riga

        Occorrenza<String> nuovaOcc; //Mette le parole delle righe qua
        Occorrenza<String> occTrovata; //Usa nuovaOcc per cercare nella tavola

        //Finché il file ha righe
        while((rigaFile = fileIn.readLine()) != null){
            stk = new StringTokenizer(rigaFile, " \t,.;:?!\"'");

            //Finché la riga ha token
            while(stk.hasMoreTokens()){
                parola = stk.nextToken().toLowerCase(); //Prendo uno parola

                nuovaOcc = new Occorrenza<String>(parola); //Creo una occorrenza con la parola
                occTrovata = tavolaOccorrenze.find(nuovaOcc); //Cerca l'occorrenza nella tavola
                if(occTrovata != null) //Se la trova
                    occTrovata.incrementa(); //Incrementa contatore
                else
                    tavolaOccorrenze.add(nuovaOcc); //Altrimenti aggiunge occorrenza
            }
        }

        //Visualizza tavola
        out.println("Occorrenze: ");
        for(Occorrenza<String> o : tavolaOccorrenze)
            out.println(o.toString());
    }
}
