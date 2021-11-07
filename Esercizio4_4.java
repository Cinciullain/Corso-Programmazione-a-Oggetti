/*
Usando gli array di Java e la classe Importo e il tipo enumerativo MeseDellAnno, scrivere un programma che
legge le entrate monetare per ogni mese di un anno, indica l’importo dell’entrata media mensile ed elenchi i
mesi che hanno avute entrate inferiori alla media.
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.utili.Importo;
import prog.utili.MeseDellAnno;

public class Esercizio4_4 {
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
        for(Importo imp : entrate){
            somma = somma.piu(imp);
        }

        //Calcolo medie e output
        Importo mediaMensile = somma.diviso(NMESI);
        Importo entrateMese;
        out.println("Media: " + mediaMensile);
        for(MeseDellAnno mese : MeseDellAnno.values()){
            entrateMese = entrate[mese.ordinal()];

            if(entrateMese.isMinore(mediaMensile))
                out.println(mese + ": Euro: " + entrateMese);
        }
    }
}
