/*
    Esercizio: 6.1
    Descrizione: Estendo esercizio 6_1 aggiungendo triangoli
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.utili.Figura;
import prog.utili.Quadrato;
import prog.utili.Rettangolo;
import prog.utili.Triangolo;

public class Esercizio6_2 {

    private static Figura leggiFigura(double b, double h, double a){
        if(a == 0) {
            if (b == h)
                return new Quadrato(b);
            else
                return new Rettangolo(b, h);
        } else
            return new Triangolo(b, h, a);
    }

    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        Figura maggiore = null;
        Figura attuale;
        do{
            attuale = leggiFigura(in.readDouble("Base: "), in.readDouble("Altezza: "), in.readDouble("Angolo? "));
            if(maggiore == null || attuale.haAreaMaggiore(maggiore))
                maggiore = attuale;
        }while(in.readSiNo("Continuare? (s/n): "));

        if(maggiore instanceof Quadrato)
            out.println("Quadrato: " + maggiore);
        else if(maggiore instanceof Rettangolo)
            out.println("Rettangolo: " + maggiore);
        else
            out.println("Triangolo: " + maggiore);
    }

}
