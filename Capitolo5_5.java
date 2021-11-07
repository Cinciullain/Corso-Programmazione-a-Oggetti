/*
Calcola guadagno giornaliero utilizzato enum dei mesi e for-each
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.utili.Importo;
import prog.utili.MeseDellAnno;

public class Capitolo5_5 {
    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        final int NMESI = MeseDellAnno.values().length;
        final int NGIORNI = 365;
        Importo[] entrate = new Importo[NMESI];
        Importo tmp;

        //Inizializzo array entrate per ogni mese
        for(MeseDellAnno mese : MeseDellAnno.values()){
            out.println("Entrate di " + mese + ":");
            tmp = new Importo(in.readInt("Euro?"), in.readInt("Cent?"));

            entrate[mese.ordinal()] = tmp;
        }

        //Somma totale entrate
        Importo somma = new Importo(0);
        for(Importo imp : entrate)
            somma = somma.piu(imp);

        //Calcolo medie e output
        Importo mediaMensile = somma.diviso(NMESI);
        Importo mediaGiornaliera = somma.diviso(NGIORNI);
        Importo entrateMese, mediaGiornalieraMese;
        int giorniMese;
        for(MeseDellAnno mese : MeseDellAnno.values()){
            entrateMese = entrate[mese.ordinal()];
            giorniMese = mese.numeroGiorni();
            mediaGiornalieraMese = entrateMese.diviso(giorniMese);

            out.println(mese + ": Euro: " + mediaGiornalieraMese);
        }
    }
}
