/*
    Capitolo: 9.5
    Esercizio: 9.15
    Descrizione: Classe prova per classe Matrice
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;

import java.util.Calendar;

public class MatriciProva {

    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        int[][] m = new int[4][2];
        int i, j;
        for(i = 0; i < 4; i++){
            for(j = 0; j < 2; j++){
                m[i][j] = in.readInt();
            }
        }

        //Test tutti i metodi 9.15
        for(i = 0; i < 4; i++)
            out.println("R: " + (i + 1) + " somma: " + Matrici.sommaRighe(m)[i]);

        for(j = 0; j < 2; j++)
            out.println("C: " + (j + 1) + " somma: " + Matrici.sommaColonne(m)[j]);

        for(i = 0; i < 4; i++)
            out.println("R: " + (i + 1) + " min: " + Matrici.calcoloMinimoRiga(m)[i]);

        for(j = 0; j < 2; j++)
            out.println("C: " + (j + 1) + "min: " + Matrici.calcolaMinimoColonna(m)[j]);

        out.println("Somma tot: " + Matrici.sommaMatrice(m));
        out.println("Min tot: " + Matrici.minimoMatrice(m));

        //Test metodi 9.16
        String[][] stringhe = new String[][] {{"Ciao", "Pippo"}, {"Mirko", "tonio"}, {"marco", "alessandro"}};
        out.println(Matrici.minimoMatrice(stringhe));

        String[] arr = new String[stringhe.length];
        arr = Matrici.calcolaMinimoRiga(stringhe, arr);
        for(String o : arr)
            out.println(o);

        Integer[][] simmetrica;
        simmetrica = new Integer[][] {{2, 3, 6},{3, 4, 5},{6, 5, 9}};
        out.println(Matrici.simmetrica(simmetrica)); //check true

        Integer[][] nonSimmetrica;
        nonSimmetrica = new Integer[][] {{1,2,3}, {4,5,6}, {7,8,9}};
        out.println(Matrici.simmetrica(nonSimmetrica)); //check false

        String[][] stringSimmetrica = new String[][] {{"Pippo", "Ciao"},{"Ciao", "Pippo"}};
        out.println(Matrici.simmetrica(stringSimmetrica));
    }
}
