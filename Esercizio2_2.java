/*
Scrivete un'applicazione che legga una frazione e un esponente (numero intero) e calcoli la frazione
ottenuta elevando la frazione data all'esponente. Ad esempio, se viene letta la frazione 2/3 e
l'esponente è 3, il risultato dovrà essere la frazione 8/27, se invece viene letta la frazione 2/3 e
l'esponente è -3, il risultato dovrà essere la frazione 27/8. Calcolare la potenza con un ciclo iterativo
e avvalersi della classe Frazione.
*/

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.utili.Frazione;
import java.lang.Math;

public class Esercizio2_2 {

    public static void main(String[] args) {
        ConsoleOutputManager out = new ConsoleOutputManager();
        ConsoleInputManager in = new ConsoleInputManager();

        int esponente = 0, tmp = 0;
        Frazione fr = new Frazione(in.readInt("Numeratore: "), in.readInt("Denominatore: "));
        esponente = in.readInt("Esponente: ");

        //Metodo 1
        if(esponente >= 0)
            out.println(Math.pow(fr.getNumeratore(), esponente) + "/" + Math.pow(fr.getDenominatore(), esponente));
        else
            out.println(Math.pow(fr.getDenominatore(), -esponente) + "/" + Math.pow(fr.getNumeratore(), -esponente));
    }
}
