/*
    Scrivete un'applicazione che legga i prezzi dei prodotti acquistati e la percentuale di sconto, e comunichi il
    prezzo totale da pagare, avendo applicato lo sconto solo prodotto più costoso.
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.utili.Importo;

public class Esercizio3_1 {

    public static void main(String[] args) {

        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        Importo totale = new Importo(0);
        Importo tmp;

        do{
            tmp = new Importo(in.readInt("Euro: "), in.readInt("Cent: "));
            totale = totale.piu(tmp);
        }while(in.readSiNo("Altro?"));

        int sconto = in.readInt("Sconto?");
        Importo totScontato = totScontato = (totale.diviso(100)).per(sconto);
        out.println("Totale: " + totale.getEuro() + "," + totale.getCent());
        out.println("Sconto: " + sconto + "% " + "su " + totale.toString() + " = " + totScontato);
        out.print("Totale scontato: " + (totale.meno(totScontato)));
    }
}
