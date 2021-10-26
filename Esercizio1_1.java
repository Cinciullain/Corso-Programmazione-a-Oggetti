/*  primo addendo? 4
    secondo addendo? 5
            4 + 5 = 9
    Quattro + Cinque = Nove
*/

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.utili.Intero;

public class Esercizio1_1 {

    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        Intero ad1, ad2;
        ad1 = new Intero(in.readInt("Primo addendo "));
        ad2 = new Intero(in.readInt("Secondo addendo "));
        Intero ris = new Intero(ad1.intValue() + ad2.intValue());

        out.println(ad1.intValue() + " + " + ad2.intValue() + " = " + ris.intValue());
        out.println(ad1.toString() + " + " + ad2.toString() + " = " + ris.toString());

    }
}
