/*
    Capitolo: 9.5
    Esercizio: 9.15
    Descrizione: Classe prova per classe Matrice
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;

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
    }
}
