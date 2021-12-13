/*
Usando gli array di Java, scrivete un'applicazione che, letta da tastiera una sequenza di numeri interi,
dove il numero di elementi della sequenza è anch'esso stabilito dall'utente, produce in output la sequenza in
ordine crescente (si suggerisce di usare il semplice algoritmo selection sort).
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;

public class Esercizio4_1 {

    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        int lunghezzaArray = in.readInt("Inserire lunghezza array: ");
        int[] arrayInteri = new int[lunghezzaArray];

        int i;
        for(i = 0; i < lunghezzaArray; i++)
            arrayInteri[i] = in.readInt("Inserisci numero: ");

        int j, min, tmp;
        for(i = 0; i < lunghezzaArray; i++){
            min = i;
            for(j = i + 1; j < lunghezzaArray; j++){
                if(arrayInteri[j] < arrayInteri[min])
                    min = j;
            }
            if(min != i){
                tmp = arrayInteri[i];
                arrayInteri[i] = arrayInteri[min];
                arrayInteri[min] = tmp;
            }
        }

        for(i = 0; i < lunghezzaArray; i++)
            out.println(arrayInteri[i]);
    }
}
