/*
    Vincoli sui generici <?>
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.utili.Cerchio;
import prog.utili.Figura;
import prog.utili.Quadrato;
import prog.utili.Sequenza;

public class Capitolo6_16 {

    public static void main(String[] args) {

        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        char scelta = in.readChar("Cerchio o Quadrato (c/q)? ");
        while(scelta != 'c' && scelta != 'q'){
            out.println("Scelta non valida");
            scelta = in.readChar("Cerchio o Quadrato (c/q)? ");
        }

        Sequenza<? extends Figura> seq = null;
        Sequenza<Cerchio> sc;
        Sequenza<Quadrato> sq;
        int lato;
        double raggio;

        switch (scelta){
            case 'c':
                sc = new Sequenza<Cerchio>();
                while((raggio = in.readDouble("Raggio, (0 per terminare): ")) != 0);
                    sc.add(new Cerchio(raggio));
                seq = sc;
                break;

            case 'q':
                sq = new Sequenza<Quadrato>();
                while((lato = in.readInt("Lato, (0 per terminare): ")) != 0)
                    sq.add(new Quadrato(lato));
                seq = sq;
                break;
        }

        for(Figura f : seq)
            out.println(f.getArea());
    }
}
