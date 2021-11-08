/*
    Esercizio: 6.1
    Descrizione: Utilizzando le classi Rettangolo e Quadrato (estensione di Rettangolo) del package
    prog.utili, scrivere un’applicazione che legge una sequenza di figure e indica quella di area massima
    specificandone anche il tipo (quadrato o rettangolo e il perimetro)
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.utili.Quadrato;
import prog.utili.Rettangolo;

public class Esercizio6_1 {

    private static Rettangolo leggiRettangolo(int b, int h){
        if(b == h)
            return new Quadrato(b);
        else
            return new Rettangolo(b, h);
    }

    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        Rettangolo maggiore = null;
        Rettangolo attuale;
        do{
            attuale = leggiRettangolo(in.readInt("Base: "), in.readInt("Altezza: "));
            if(maggiore == null || attuale.haAreaMaggiore(maggiore))
                maggiore = attuale;
        }while(in.readSiNo("Continuare? (s/n): "));

        if(maggiore instanceof Quadrato)
            out.println("Quadrato: " + maggiore);
        else
            out.println("Rettangolo: " + maggiore);
    }

}
