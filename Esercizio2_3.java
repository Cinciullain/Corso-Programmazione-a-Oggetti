/*
Scrivete un'applicazione che, ricevendo in ingresso un numero intero positivo, indichi se tale
numero è primo. Costruitene diverse versioni. In una prima versione provate a dividere il numero
per tutti i numeri minori mediante un ciclo for, al fine di verificare l'esistenza di un divisore. In
un'altra versione interrompete l'iterazione quando è stato individuato un divisore. In un'ulteriore
versione riducete il numero massimo d'iterazioni osservando che se un numero ammette un
divisore, allora ammette anche un divisore minore o uguale alla propria radice quadrata.
*/

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;

public class Esercizio2_3 {

    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        int input = 0, contatore = 0;
        input = in.readInt("Inserisci numero: ");

        //Metodo 1
        for(int i = input; i > 0; i--){
            if(input % i == 0)
                contatore++;
        }
        if(contatore == 2)
            out.println("Primo");

        //Metodo 2
        boolean check = false;
        for(int i = 2; i < input; i++){
            if(input % i == 0) {
                check = true;
                break;
            }
        }
        if(check)
            out.println("Non primo");

    }
}
