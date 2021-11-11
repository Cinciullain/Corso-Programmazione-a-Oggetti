/*
    Capitolo: 9.5
    Esercizio: 9.15
    Descrizione: Creare una classe per la gestione di matrici con metodi statici tra cui:
    -Calcolo somma di singole righe, colonne
    -Calcolo del minimo di ciascuna riga, colonna
    -Calcolo somma matrice
    -Calcolo minimo numero matrice

 */

public class Matrici {

    public static int[] sommaRighe(int[][] m){
        int lunghezza = m.length;
        int somma = 0;
        int i, j;
        int[] arraySomme = new int[lunghezza];

        for(i = 0; i < lunghezza; i++){
            for(j = 0; j < m[lunghezza - 1].length; j++)
                somma += m[i][j];

            arraySomme[i] = somma;
        }

        return arraySomme;
    }

    public static int[] sommaColonne(int[][] m){
        int lunghezza = m.length;
        int somma = 0;
        int i, j;
        int[] arraySomme = new int[lunghezza];

        for(j = 0; j < m[lunghezza - 1].length; j++)
            arraySomme[j] = 0;

        for(j = 0; j < m[lunghezza - 1].length; j++){
            for(i = 0; i < lunghezza; i++){
                arraySomme[j] += m[i][j];
            }
        }

        return arraySomme;
    }

    public static int[] calcoloMinimoRiga(int[][] m){
        int lunghezza = m.length;
        int[] minimo = new int[lunghezza];
        int i, j;
        for(i = 0; i < lunghezza; i++){
            for(j = 0; j < m[lunghezza - 1].length; j++){
                if(j == 0)
                    minimo[i] = m[i][j];
                else if(minimo[i] > m[i][j])
                    minimo[i] = m[i][j];
            }
        }

        return minimo;
    }

    public static int[] calcolaMinimoColonna(int[][] m){
        int lunghezza = m.length;
        int[] minimo = new int[lunghezza];
        int i, j;

        for(j = 0; j < m[lunghezza - 1].length; j++){
            for(i = 0; i < lunghezza; i++){
                if(i == 0)
                    minimo[j] = m[i][j];
                else if(minimo[j] > m[i][j])
                    minimo[j] = m[i][j];
            }
        }

        return minimo;
    }

    public static int sommaMatrice(int[][] m){
        int somma = 0;
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[m.length - 1].length; j++)
                somma += m[i][j];
        }

        return somma;
    }

    public static int minimoMatrice(int[][] m){
        int iMin = 0, jMin = 0;
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[m.length - 1].length; j++) {
                if(m[i][j] < m[iMin][jMin]){
                    iMin = i;
                    jMin = j;
                }
            }
        }

        return m[iMin][jMin];
    }
}
