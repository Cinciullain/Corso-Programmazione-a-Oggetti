/*
    Usare la lasse GestioneArray con una classe che implementi Comparable, come Frazione, e fare un array
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.utili.Frazione;
import prog.utili.GestioneArray;

public class Libro6_22 {

    public static void main(String[] args) {

        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        int numeratore, denominatore;
        Frazione[] frazioni = new Frazione[10];

        for(int i = 0; i < 10; i++){
            numeratore = in.readInt("Numeratore: ");
            denominatore = in.readInt("Denominatore: ");
            frazioni[i] = new Frazione(numeratore, denominatore);
        }

        GestioneArray.ordina(frazioni);
        for(Frazione f : frazioni)
            out.println(f);
    }
}
