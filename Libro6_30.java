/*
    Applicazione che legga i dati di 5 quadrati, memorizzi gli oggetti corrispondenti in un array di tipo Quadrato,
    e infine scandisca l'array invocando il metodo toString di ogni oggetto in esso contenuto.
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.utili.Figura;
import prog.utili.Quadrato;
import prog.utili.Rettangolo;

public class Libro6_30 {

    public static void main(String[] args) {

        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        Quadrato[] aq = new Quadrato[5];

        for(int i = 0; i < 5; i++)
            aq[i] = new Quadrato(in.readInt("Inserisci lato: "));

        for(Quadrato q : aq)
            out.println(q.toString());
    }
}
