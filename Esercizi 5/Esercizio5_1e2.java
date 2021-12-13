/*
Utilizzando la classe Importo e il tipo enumerativo MeseDellAnno, scrivere un programma che legge le
entrate monetare per ogni mese di una sequenza di anni e indica:
- l’entrata media per ogni anno
- gli anni che hanno avuto entrata inferiore alla media
- per ogni anno: l’importo dell’entrata media mensile e i mesi che hanno avute entrate inferiori alla media.
Utilizzare array multidimensionali. Se ritenuto necessario per una maggiore leggibilità, organizzare il codice
in sottoprogrammi, definendo opportuni metodi della classe contenente il metodo main().
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.utili.Importo;
import prog.utili.MeseDellAnno;

public class Esercizio5_1e2 {
    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        final int NMESI = MeseDellAnno.values().length;
        final int NGIORNI = 365;
        final int NANNI = 3;

        Importo[][] entrate = new Importo[NANNI][NMESI];
        Importo tmp;

        //Inizializzo array
        int i;
        for(i = 0; i < NANNI; i++){
            for(MeseDellAnno mese : MeseDellAnno.values()){
                out.println("Entrate di: " + mese + " Anno: " + (i + 1));
                tmp = new Importo(in.readInt("Euro?"), in.readInt("Cent?"));
                entrate[i][mese.ordinal()] = tmp;
            }
        }

        //Somma totale entrate
        Importo[] somma = new Importo[NANNI];
        for(i = 0; i < NANNI; i++)
            somma[i] = new Importo(0);
        for(i = 0; i < NANNI; i++){
            for(Importo imp : entrate[i])
                somma[i] = somma[i].piu(imp);
        }

        //Entrata media ogni anno, anno inferiore media, media giornaliera
        int min = 0, giorniMese;
        Importo media = null;
        for(i = 0; i < NANNI; i++){
            out.println("Media anno " + (i + 1) + ": " + somma[i].diviso(NMESI));
            out.println("Media giornaliera anno " + (i + 1) + ": " + somma[i].diviso(NMESI).diviso(NGIORNI));
            if(media == null || media.isMaggiore(somma[i].diviso(NMESI))) {
                min = i;
                media = somma[i].diviso(NMESI);
            }
        }
        out.println("Anno media inferiore: " + (min + 1) + " Media: " + media);

    }
}
