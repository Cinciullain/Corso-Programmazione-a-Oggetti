/*
Utilizzando il metodo nextBoolean della classe Random, scrivete un'applicazione che simuli una sequenza
di lanci di moneta, dove il numero di lanci viene inserito preliminarmente dall'utente. Calcolate via via la
percentuale di lanci che forniscono come risultato “testa" e la percentuale di lanci che forniscono come
risultato "croce". Al crescere del numero di lanci le due percentuali dovrebbero stabilizzarsi a intorno al 50%
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;

import java.util.Random;

public class Esercizio3_2 {

    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();
        Random random = new Random();

        int input = in.readInt("Grandezza: ");
        boolean[] array = new boolean[input];
        for(int i = 0; i < input; i++)
            array[i] = random.nextBoolean();

        int testa = 0;
        for(boolean a : array){
            if(a)
                testa++;
        }

        float percentuale = 100 * (float)testa / (float)input;
        out.println(percentuale);
        out.println(testa);
        out.println(input - testa);
    }
}
