/*
Usando gli array di Java, riscrivete l'applicazione dell’Esercizio 1 in modo che tratti sequenze di lunghezza
arbitraria. A tale scopo potete procedere come segue: inizialmente fate riferire una variabile numeri a un array
di 10 elementi. Se durante il ciclo di lettura l'array viene riempito, create un nuovo array con un numero doppio
di posizioni; nella prima metà copiate gli elementi già letti e contenuti nell'array riferito da numeri.
Fate pertanto riferire numeri al nuovo array e proseguite l'inserimento. In altre parole, ogni volta che si satura
la capacità dell'array, lo sostituite con uno nuovo, di capacità doppia, nel quale trasferite i dati
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;

public class Esercizio4_3 {

    public static void main(String[] args) {

        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        int lunghezzaArray = 10;
        int[] arrayInteri = new int[lunghezzaArray];
        int[] arrayTmp = new int[lunghezzaArray];

        int i = 0;
        while((in.readSiNo("Vuoi inserire numero? (s/n): ")) && i < lunghezzaArray){
            arrayInteri[i] = in.readInt("Inserisci intero: ");
            i++;
        }

        if(i == lunghezzaArray){
            boolean check = false;
            do{
                lunghezzaArray = lunghezzaArray * 2;

                for(i = 0; i < arrayInteri.length; i++)
                    arrayTmp[i] = arrayInteri[i];

                arrayInteri = new int[lunghezzaArray];
                for(i = 0; i < arrayTmp.length; i++)
                    arrayInteri[i] = arrayTmp[i];
                arrayTmp = new int[lunghezzaArray];

                out.println("i: " + i);

                while((in.readSiNo("Vuoi inserire numero? (s/n): ")) && i < lunghezzaArray){
                    arrayInteri[i] = in.readInt("Inserisci intero: ");
                    i++;
                }

                if(i == lunghezzaArray)
                    check = in.readSiNo("Ingrandire array? (s/n): ");
            }while(check);
        }

        for(i = 0; i < arrayInteri.length; i++)
            out.println(arrayInteri[i]);

    }
}
