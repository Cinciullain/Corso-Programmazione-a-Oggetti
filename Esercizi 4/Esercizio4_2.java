/*
Usando gli array di Java, scrivete un'applicazione che, letta da tastiera una sequenza di frazioni,
dove il numero di elementi della sequenza è anch'esso stabilito dall'utente, produce in output la sequenza in
ordine crescente (si suggerisce di usare il semplice algoritmo selection sort).
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.utili.Frazione;

public class Esercizio4_2 {

    public static void main(String[] args) {

        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        int lunghezzaArray = in.readInt("Inserire lunghezza array: ");
        Frazione[] arrayFrazioni = new Frazione[lunghezzaArray];


        int i, numeratore, denominatore;
        for(i = 0; i < lunghezzaArray; i++){
            numeratore = in.readInt("Numeratore: ");
            denominatore = in.readInt("Denominatore: ");
            arrayFrazioni[i] = new Frazione(numeratore, denominatore);
        }

        int j, min;
        Frazione tmp;
        for(i = 0; i < lunghezzaArray; i++){
            min = i;
            for(j = i + 1; j < lunghezzaArray; j++){
                if(arrayFrazioni[j].isMinore(arrayFrazioni[min]))
                    min = j;
            }
            if(min != i){
                tmp = arrayFrazioni[i];
                arrayFrazioni[i] = arrayFrazioni[min];
                arrayFrazioni[min] = tmp;
            }
        }

        for(i = 0; i < lunghezzaArray; i++)
            out.println(arrayFrazioni[i].toString());
    }
}
