/*
Scrivete un'applicazione che riceva in ingresso due numeri in virgola mobile x e y (con y >= x >= 1) e calcoli
(in maniera approssimata) l'integrale da x a y della funzione logaritmo.
Il calcolo può basarsi sulla seguente idea (nell'ipotesi che y >= x >= 1):
1. Si prenda in esame un rettangolo con base coincidente con l'intervallo considerato, cioè da x a y, e con altezza
uguale al valore massimo della funzione nell'intervallo (in questo caso log(y)).
2. Si generano molti punti a caso all'interno di questo rettangolo.
3. Il rapporto tra il numero di punti che si trovano al di sotto della funzione e il numero di punti generati sarà
circa uguale al rapporto tra l'integrale da calcolare e l'area del rettangolo.
Implementate quest'idea nella vostra applicazione, utilizzando la classe Random, descritta nell'esercizio precedente.
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.utili.Rettangolo;

public class Esercizio3_3COMPLETARE {

    public static void main(String[] args) {

        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        double x, y;
        do{
            out.println("Inserisci y>=x>=1");
            x = in.readDouble("Inserisci X");
            y = in.readDouble("Inserisci Y");
        }while(x < 1 || y < x);

        Rettangolo rettangolo = new Rettangolo(y-x, Math.log(y));
    }
}
